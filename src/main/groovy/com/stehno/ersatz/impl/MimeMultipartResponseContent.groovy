package com.stehno.ersatz.impl

import com.stehno.ersatz.ContentType
import com.stehno.ersatz.MultipartResponseContent
import com.stehno.ersatz.ResponseEncoders
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor
import org.xnio.streams.ReaderInputStream

import javax.activation.DataHandler
import javax.activation.DataSource
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart
import java.util.function.Consumer
import java.util.function.Function

import static com.stehno.ersatz.ContentType.TEXT_PLAIN

/**
 * FIXME: document
 */
@CompileStatic
class MimeMultipartResponseContent extends MultipartResponseContent {

    private final MimeMultipart message = new MimeMultipart()
    private final ResponseEncoders localEncoders = new ResponseEncoders()
    private final EncoderChain encoderChain = new EncoderChain(localEncoders)

    /**
     * Creates a new multipart response content object with the optional boundary (random default) and a Closure used to configure the parts.
     *
     * @param closure the configuration closure (Delegates to MultipartContent instance)
     * @return a reference to this MultipartResponseContent instance
     */
    static MultipartResponseContent mimeMultipart(final @DelegatesTo(MultipartResponseContent) Closure closure) {
        MultipartResponseContent content = new MimeMultipartResponseContent()
        closure.delegate = content
        closure.call()
        content
    }

    /**
     * Creates a new multipart response content object with the optional boundary (random default) and a Consumer used to configure the parts. The
     * Consumer will have an instance of MultipartContent passed into it for configuration.
     *
     * @param closure the configuration consumer (given an instance of MultipartContent)
     * @return a reference to this MultipartResponseContent instance
     */
    static MultipartResponseContent mimeMultipart(final Consumer<MultipartResponseContent> consumer) {
        MultipartResponseContent content = new MimeMultipartResponseContent()
        consumer.accept(content)
        content
    }

    @Override
    MultipartResponseContent encoders(final ResponseEncoders responseEncoders) {
        encoderChain.second(responseEncoders)
        this
    }

    @Override
    MultipartResponseContent boundary(String value) {
        throw new UnsupportedOperationException('Boundary specification is not supported by this implementation.')
    }

    @Override
    MultipartResponseContent encoder(final String contentType, final Class type, final Function<Object, String> encoder) {
        localEncoders.register(contentType, type, encoder)
        this
    }

    @Override
    MultipartResponseContent encoder(final ContentType contentType, final Class type, final Function<Object, String> encoder) {
        localEncoders.register(contentType.value, type, encoder)
        this
    }

    @Override
    MultipartResponseContent field(String fieldName, String value) {
        part fieldName, TEXT_PLAIN, value
    }

    @Override
    MultipartResponseContent part(String fieldName, String contentType, Object value) {
        part fieldName, null, contentType, value, null
        this
    }

    @Override
    MultipartResponseContent part(String fieldName, ContentType contentType, Object value, String transferEncoding) {
        part fieldName, null, contentType, value, transferEncoding
        this
    }

    @Override
    MultipartResponseContent part(String fieldName, String fileName, String contentType, Object value, String transferEncoding) {
        MimeBodyPart bodyPart = new MimeBodyPart()
        bodyPart.disposition = 'form-data'

        if (fileName) {
            bodyPart.setFileName(fileName)
            bodyPart.setHeader('Content-Disposition', "form-data; name=\"${fieldName}\"; filename=\"${fileName}\"")

        } else {
            bodyPart.setHeader('Content-Disposition', "form-data; name=\"${fieldName}\"")
        }

        if (transferEncoding) {
            bodyPart.setHeader('Content-Transfer-Encoding', transferEncoding)
        }

        bodyPart.setDataHandler(new DataHandler(new EncodedDataSource(encoderChain, contentType, value)))

//        bodyPart.setHeader('Content-Type', contentType)

        message.addBodyPart(bodyPart)
        this
    }

    @Override
    MultipartResponseContent part(String fieldName, String fileName, ContentType contentType, Object value, String transferEncoding) {
        part fieldName, fileName, contentType.value, value, transferEncoding
    }

    @Override
    String getContentType() {
        message.contentType
    }
}

@CompileStatic @TupleConstructor
class EncodedDataSource implements DataSource {

    final EncoderChain encoderChain
    final String contentType
    final Object value

    @Override
    InputStream getInputStream() throws IOException {
        new ReaderInputStream(new StringReader(encoderChain.resolve(contentType, value.class).apply(value)))
    }

    @Override
    OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException('Writing is not supported.')
    }

    @Override
    String getName() {
        return null
    }
}