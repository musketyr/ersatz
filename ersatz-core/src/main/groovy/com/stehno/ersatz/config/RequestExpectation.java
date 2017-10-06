package com.stehno.ersatz.config;

import com.stehno.ersatz.ClientRequest;
import com.stehno.ersatz.Cookie;
import org.hamcrest.Matcher;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by cjstehno on 10/6/17.
 */
public interface RequestExpectation {

    /**
     * Specifies that the request protocol be equal to (case-insensitive) the specified value.
     *
     * @param proto the request protocol
     * @return this request
     */
    RequestExpectation protocol(final String proto);

    /**
     * Specifies a request header to be configured in the expected request. The value specified must match one of the request header values mapped to
     * the expected header name. Multiple header specification may be added to the expectations; each specified header must exist in the request. If
     * an OR-style match is desired a Hamcrest Matcher should be specified (see the <code>header(String, Matcher<Iterable<String>>)</code> method).
     *
     * @param name  the header name
     * @param value the header value
     * @return this request
     */
    RequestExpectation header(final String name, final String value);

    /**
     * Specifies a request header matcher to be configured in the expected request. If multiple matchers are defined with this method, each must
     * match successfully for the request to be matched.
     *
     * @param name    the header name
     * @param matcher the header value matcher
     * @return this request
     */
    RequestExpectation header(final String name, final Matcher<Iterable<String>> matcher);

    /**
     * Specifies request headers as a Map of names to values to be configured in the expected request. The map values may be <code>String</code> or
     * <code>Matcher<Iterable<String>></code> instances.
     *
     * @param heads the map of headers
     * @return this request
     */
    RequestExpectation headers(final Map<String, Object> heads);

    /**
     * Used to specify a request query parameter to be configured in the expected request. As per the HTTP spec, the query string parameters may be
     * specified multiple times with different values to denote a parameter with multiple values.
     *
     * @param name  the parameter name
     * @param value the parameter value
     * @return this request
     */
    RequestExpectation query(final String name, final String value);

    /**
     * Used to specify a request query parameter to be configured in the expected request. As per the HTTP spec, the query string parameters may be
     * specified multiple times with different values to denote a parameter with multiple values.
     *
     * @param name   the parameter name
     * @param values the list of values
     * @return this request
     */
    RequestExpectation query(final String name, final Iterable<String> values);

    /**
     * Used to specify a request query parameter to be configured in the expected request. As per the HTTP spec, the query string parameters may be
     * specified multiple times with different values to denote a parameter with multiple values.
     *
     * @param name    the parameter name
     * @param matcher the query string matcher
     * @return this request
     */
    RequestExpectation query(final String name, final Matcher<Iterable<String>> matcher);

    /**
     * Used to specify a map of request query parameters for configuration on the expected request. The map values may be Strings or Matchers.
     *
     * @param map the map of query parameters
     * @return this request
     */
    RequestExpectation queries(final Map<String, Object> map);

    /**
     * Specifies a request cookie to be configured with the given name and value.
     *
     * @param name  the cookie name
     * @param value the cookie value
     * @return this request
     */
    RequestExpectation cookie(final String name, final String value);

    /**
     * Specifies a request cookie to be configured with the given name and matcher.
     *
     * @param name    the cookie name
     * @param matcher the cookie matcher
     * @return this request
     */
    RequestExpectation cookie(final String name, final Matcher<Cookie> matcher);

    /**
     * Specifies a matcher for matching all cookies. This is useful with the <code>NoCookiesMatcher</code>.
     *
     * @param matcher the matcher to be used
     * @return this request
     */
    RequestExpectation cookies(final Matcher<Map<String, Cookie>> matcher);

    /**
     * Used to configure a map of cookies on the request. The map values may be Strings or Matchers. All of the configured matchers must be successful
     * in order for the request to be matched.
     *
     * @param cookies the map of cookies
     * @return this request
     */
    RequestExpectation cookies(final Map<String, Object> cookies);

    /**
     * Specifies a listener which will be called with the active request whenever this request is matched at test-time.
     *
     * @param listener the request call listener
     * @return a reference to this request
     */
    RequestExpectation listener(final Consumer<ClientRequest> listener);

    /**
     * Allows the specification of a custom call verifier so that the number of times the request is called may be matched.
     *
     * @param verifier the verifier to be used
     * @return a reference to this request
     */
    RequestExpectation called(final Matcher<Integer> verifier);

    /**
     * Configures a call count verifier such that the number of calls must be equivalent to the provided count. This is analogous to calling
     * <code>called(equalTo(n))</code>.
     *
     * @param count the expected call count for the request
     * @return a reference to this request
     */
    RequestExpectation called(final int count);

    /**
     * Initiates the definition of a response for this request.
     *
     * @return a response for this request, for configuration
     */
    ResponseExpectation responds();

    /**
     * Allows for configuration of a <code>Response</code> by the given <code>Consumer</code>, which will have a <code>Response</code> object passed
     * into it.
     *
     * @param responder the <code>Consumer<Response></code> to provide configuration of the response
     * @return a reference to this request
     */
//    RequestExpectation responder(final Consumer<Response> responder)

    /**
     * Allows for configuration of a <code>Response</code> by the given Groovy <code>Closure</code>, which will delegate to a <code>Response</code>
     * instance passed into it for configuration using the Groovy DSL.
     *
     * @param closure the <code>Consumer<Response></code> to provide configuration of the response
     * @return a reference to this request
     */
//    RequestExpectation responder(@DelegatesTo(Response) final Closure closure)
}
