package com.stehno.ersatz.config;

import com.stehno.ersatz.ContentType;
import com.stehno.ersatz.DecodingContext;

import java.net.URL;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Configuration interface for an Ersatz server instance.
 */
public interface ErsatzConfig {

    // FIXME: consider if these interfaces are actually needed - should I just collapse everything down into concrete objects?

    /**
     * Used to control the enabled/disabled state of HTTPS on the server. By default HTTPS is disabled.
     *
     * @return a reference to the server being configured
     */
    ErsatzConfig https(boolean enabled);

    /**
     * Used to enabled HTTPS on the server. By default HTTPS is disabled.
     *
     * @return a reference to the server being configured
     */
    ErsatzConfig https();

    boolean isHttpsEnabled();

    /**
     * Used to enable/disable the auto-start feature, which will start the server after any call to either of the <code>expectations</code>
     * configuration methods. With this setting enabled, any other calls to the <code>start()</code> method are ignored. Further configuration is
     * allowed.
     * <p>
     * Auto-start is enabled by default.
     *
     * @param enabled whether or not auto-start is enabled
     * @return a reference to the server being configured
     */
    ErsatzConfig autoStart(boolean enabled);

    boolean isAutoStartEnabled();

    /**
     * Causes the mismatched request reports to be generated as console output, rather than only in the logging.
     *
     * @return a reference to the server being configured
     */
    ErsatzConfig reportToConsole();

    /**
     * Used to toggle the console output of mismatched request reports. By default they are only rendered in the logging. A value of <code>true</code>
     * will cause the report to be output on the console as well.
     *
     * @param toConsole whether or not the report should also be written to the console
     * @return a reference to the server being configured
     */
    ErsatzConfig reportToConsole(boolean toConsole);

    boolean isReportToConsoleEnabled();

    /**
     * Allows configuration of an external HTTPS keystore with the given location and password. By default, if this is not specified an internally
     * provided keystore will be used for HTTPS certification. See the User Guide for details about configuring your own keystore.
     *
     * @param location the URL of the keystore file
     * @param password the keystore file password
     * @return a reference to the server being configured
     */
    ErsatzConfig keystore(URL location, String password);

    /**
     * Allows configuration of an external HTTPS keystore with the given location (using the default password "ersatz"). By default, if this is not
     * specified an internally provided keystore will be used for HTTPS certification. See the User Guide for details about configuring your own
     * keystore.
     *
     * @param location the URL of the keystore file
     * @return a reference to the server being configured
     */
    ErsatzConfig keystore(URL location);

    URL getKeystoreLocation();

    String getKeystorePass();

    /**
     * FIXME: document
     */
    ErsatzConfig expectations(ExpectationConfig expectationConfig);

    // TODO: is this the best place for this?
    void clearExpectations();

    // TODO: is this the best place for this?
    boolean verifyExpectations();

    ExpectationConfig getExpectations();

    /**
     * Configures the given request content decoder for the specified request content-type. The decoder will be configured globally and used if no
     * overriding decoder is provided during expectation configuration.
     *
     * @param contentType the request content-type
     * @param decoder     the request content decoder
     * @return the reference to the server configuration
     */
    ErsatzConfig decoder(final String contentType, final BiFunction<byte[], DecodingContext, Object> decoder);

    /**
     * Configures the given request content decoder for the specified request content-type. The decoder will be configured globally and used if no
     * overriding decoder is provided during expectation configuration.
     *
     * @param contentType the request content-type
     * @param decoder     the request content decoder
     * @return the reference to the server configuration
     */
    ErsatzConfig decoder(final ContentType contentType, final BiFunction<byte[], DecodingContext, Object> decoder);

    /**
     * Registers a global response body encoder.
     * <p>
     * param contentType the response content-type to be encoded
     *
     * @param objectType the response object type to be encoded
     * @param encoder    the encoder function
     * @return a reference to this server configuration
     */
    ErsatzConfig encoder(String contentType, Class objectType, Function<Object, String> encoder);

    /**
     * Registers a global response body encoder.
     * <p>
     * param contentType the response content-type to be encoded
     *
     * @param objectType the response object type to be encoded
     * @param encoder    the encoder function
     * @return a reference to this server configuration
     */
    ErsatzConfig encoder(ContentType contentType, Class objectType, Function<Object, String> encoder);

    /**
     * FIXME: document
     */
    ErsatzConfig authentication(AuthenticationConfig authenticationConfig);

    AuthenticationConfig getAuthentication();
}
