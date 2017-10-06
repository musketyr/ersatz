package com.stehno.ersatz.config;

import com.stehno.ersatz.ClientRequest;
import org.hamcrest.Matcher;

import java.util.List;

/**
 * FIXME: document
 */
public interface ExpectationConfig {

    /**
     * Allows configuration of a request expectation matching any request method.
     *
     * @param path the expected request path
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation any(String path);

    /**
     * Allows configuration of a request expectation matching any request method.
     *
     * @param matcher the path matcher
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation any(Matcher<String> matcher);

    /**
     * Allows configuration of a request expectation matching any request method using the Groovy DSL.
     *
     * @param path the expected request path.
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation any(String path, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a request expectation matching any request method using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation any(Matcher<String> matcher, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of request expectation matching any request method using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<Request></code> will have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation any(String path, Consumer<Request> consumer)

    /**
     * Allows configuration of request expectation matching any request method using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<Request></code> will have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation any(Matcher<String> matcher, Consumer<Request> consumer)

    /**
     * Allows configuration of a GET request expectation.
     *
     * @param path the expected request path
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation get(String path);

    /**
     * Allows configuration of a GET request expectation.
     *
     * @param matcher the path matcher.
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation get(Matcher<String> matcher);

    /**
     * Allows configuration of a GET request expectation using the Groovy DSL.
     *
     * @param path the expected request path.
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation get(String path, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a GET request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation get(Matcher<String> matcher, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a GET request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation get(String path, Consumer<Request> config)

    /**
     * Allows configuration of a GET request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation get(Matcher<String> matcher, Consumer<Request> config)

    /**
     * Allows configuration of a HEAD request expectation.
     *
     * @param path the expected request path.
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation head(String path);

    /**
     * Allows configuration of a HEAD request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation head(Matcher<String> matcher);

    /**
     * Allows configuration of a HEAD request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation head(String path, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a HEAD request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation head(Matcher<String> matcher, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a HEAD request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation head(String path, Consumer<Request> config)

    /**
     * Allows configuration of a HEAD request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation head(Matcher<String> matcher, Consumer<Request> config)

    /**
     * Allows configuration of a POST request expectation.
     *
     * @param path the request path.
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation post(String path);

    /**
     * Allows configuration of a POST request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation post(Matcher<String> matcher);

    /**
     * Allows configuration of a POST request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation post(String path, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a POST request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation post(Matcher<String> matcher, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a POST request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation post(String path, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a POST request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation post(Matcher<String> matcher, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a PUT request expectation.
     *
     * @param path the expected request path
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation put(String path);

    /**
     * Allows configuration of a PUT request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation put(Matcher<String> matcher);

    /**
     * Allows configuration of a PUT request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation put(String path, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a PUT request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation put(Matcher<String> matcher, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a PUT request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation put(String path, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a PUT request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation put(Matcher<String> matcher, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a DELETE request expectation.
     *
     * @param path the expected request path
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation delete(String path);

    /**
     * Allows configuration of a DELETE request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation delete(Matcher<String> matcher);

    /**
     * Allows configuration of a DELETE request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation delete(String path, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a DELETE request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation delete(Matcher<String> matcher, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a DELETE request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation delete(String path, Consumer<Request> config)

    /**
     * Allows configuration of a DELETE request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code> will
     * have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation delete(Matcher<String> matcher, Consumer<Request> config)

    /**
     * Allows configuration of a PATCH request expectation.
     *
     * @param path the expected request path
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation patch(String path);

    /**
     * Allows configuration of a PATCH request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>RequestWithContent</code> configuration object
     */
    RequestWithContentExpectation patch(Matcher<String> matcher);

    /**
     * Allows configuration of a PATCH request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation patch(String path, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a PATCH request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation patch(Matcher<String> matcher, @DelegatesTo(RequestWithContent) Closure closure)

    /**
     * Allows configuration of a PATCH request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation patch(String path, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a PATCH request expectation using the provided <code>Consumer<Request></code>. The
     * <code>Consumer<RequestWithContent></code> will have an instance of <code>RequestWithContent</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @pram config the configuration consumer
     * @return a <code>RequestWithContent</code> configuration object
     */
//    RequestWithContentExpectation patch(Matcher<String> matcher, Consumer<RequestWithContent> config)

    /**
     * Allows configuration of a OPTIONS request expectation.
     *
     * @param path the expected request path.
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation options(String path);

    /**
     * Allows configuration of a OPTIONS request expectation.
     *
     * @param matcher the path matcher
     * @return a <code>Request</code> configuration object
     */
    RequestExpectation options(Matcher<String> matcher);

    /**
     * Allows configuration of a OPTIONS request expectation using the Groovy DSL.
     *
     * @param path the expected request path
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation options(String path, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a OPTIONS request expectation using the Groovy DSL.
     *
     * @param matcher the path matcher
     * @pram closure the Groovy closure containing the configuration
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation options(Matcher<String> matcher, @DelegatesTo(Request) Closure closure)

    /**
     * Allows configuration of a OPTIONS request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code>
     * will have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param path the expected request path
     * @pram config the configuration consumer
     * @return a <code>Request</code> configuration object
     */
//    RequestExpectation options(String path, Consumer<Request> config)

    /**
     * Allows configuration of a OPTIONS request expectation using the provided <code>Consumer<Request></code>. The <code>Consumer<Request></code>
     * will have an instance of <code>Request</code> passed into it for configuration.
     *
     * @param matcher the path matcher
     * @return a <code>Request</code> configuration object
     * @pram config the configuration consumer
     */
//    RequestExpectation options(Matcher<String> matcher, Consumer<Request> config)

    List<RequestExpectation> getExpectations();

    RequestExpectation findMatch(ClientRequest clientRequest);
}
