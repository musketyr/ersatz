package com.stehno.ersatz.config;

import com.stehno.ersatz.ContentType;
import com.stehno.ersatz.DecodingContext;
import com.stehno.ersatz.RequestDecoders;
import org.hamcrest.Matcher;

import java.util.function.BiFunction;

/**
 * Created by cjstehno on 10/6/17.
 */
public interface RequestWithContentExpectation extends RequestExpectation {

    /**
     * Configures the expected body content of the request with the specified content type.
     *
     * @param body        the body content
     * @param contentType the body content type
     * @return a reference to this request
     */
    RequestWithContentExpectation body(final Object body, String contentType);

    /**
     * Configures the expected body content of the request with the specified content type.
     *
     * @param bodyMatcher the body content matcher
     * @param contentType the body content type
     * @return a reference to this request
     */
    RequestWithContentExpectation body(final Matcher<Object> bodyMatcher, String contentType);

    /**
     * Configures the expected body content of the request with the specified content type.
     *
     * @param body        the body content
     * @param contentType the body content type
     * @return a reference to this request
     */
    RequestWithContentExpectation body(final Object body, ContentType contentType);

    /**
     * Configures the expected body content of the request with the specified content type.
     *
     * @param bodyMatcher the body content matcher
     * @param contentType the body content type
     * @return a reference to this request
     */
    RequestWithContentExpectation body(final Matcher<Object> bodyMatcher, ContentType contentType);

    /**
     * Specifies a custom body content converter function. The function will have the client request body content as a byte array and it will be
     * converted into the specified output type. Generally the conversion is used when comparing the client request with the configured request
     * body expectation.
     *
     * @param contentType the content type that the convert will handle
     * @param decoder     the conversion function
     * @return a reference to this request
     */
    RequestWithContentExpectation decoder(final String contentType, final BiFunction<byte[], DecodingContext, Object> decoder);

    /**
     * Specifies a custom body content converter function. The function will have the client request body content as a byte array and it will be
     * converted into the specified output type. Generally the conversion is used when comparing the client request with the configured request
     * body expectation.
     *
     * @param contentType the content type that the convert will handle
     * @param decoder     the conversion function
     * @return a reference to this request
     */
    RequestWithContentExpectation decoder(final ContentType contentType, final BiFunction<byte[], DecodingContext, Object> decoder);

    /**
     * Configures a parent collection of decoders to be searched when a decoder is not configured on the request itself.
     *
     * @param decoders the parent decoder collection
     * @return a reference to this request
     */
    RequestWithContentExpectation decoders(final RequestDecoders decoders);
}
