package com.stehno.ersatz.config;

import com.stehno.ersatz.ContentType;
import com.stehno.ersatz.DecodingContext;
import com.stehno.ersatz.RequestDecoders;
import com.stehno.ersatz.ResponseEncoders;

import java.net.URL;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by cjstehno on 10/6/17.
 */
public class ErsatzConfigImpl implements ErsatzConfig {

    public static final String DEFAULT_KEYSTORE_PASSWORD = "ersatz";

    private boolean httpsEnabled;
    private boolean autoStartEnabled = true;
    private boolean reportToConsoleEnabled;
    private URL keystoreLocation;
    private String keystorePass = DEFAULT_KEYSTORE_PASSWORD;
    private AuthenticationConfig authenticationConfig;
    private final RequestDecoders globalDecoders = new RequestDecoders();
    private final ResponseEncoders globalEncoders = new ResponseEncoders();
//    FIXME: impml = private final ExpectationsImpl expectations = new ExpectationsImpl(globalDecoders, globalEncoders)

    @Override
    public ErsatzConfig https(boolean enabled) {
        this.httpsEnabled = enabled;
        return this;
    }

    @Override
    public ErsatzConfig https() {
        return https(true);
    }

    @Override
    public boolean isHttpsEnabled() {
        return httpsEnabled;
    }

    @Override
    public ErsatzConfig autoStart(boolean enabled) {
        this.autoStartEnabled = enabled;
        return this;
    }

    @Override
    public boolean isAutoStartEnabled() {
        return autoStartEnabled;
    }

    @Override
    public ErsatzConfig reportToConsole() {
        return reportToConsole(true);
    }

    @Override
    public ErsatzConfig reportToConsole(boolean enabled) {
        this.reportToConsoleEnabled = enabled;
        return this;
    }

    @Override
    public boolean isReportToConsoleEnabled() {
        return reportToConsoleEnabled;
    }

    @Override
    public ErsatzConfig keystore(URL location, String password) {
        this.keystoreLocation = location;
        this.keystorePass = password;
        return this;
    }

    @Override
    public ErsatzConfig keystore(URL location) {
        return keystore(location, DEFAULT_KEYSTORE_PASSWORD);
    }

    @Override
    public URL getKeystoreLocation() {
        return keystoreLocation;
    }

    @Override
    public String getKeystorePass() {
        return keystorePass;
    }

    @Override
    public ErsatzConfig expectations(ExpectationConfig expectationConfig) {
        return null; // FIXME: impl
    }

    @Override
    public void clearExpectations() {
        // FIXME: impl
    }

    @Override
    public boolean verifyExpectations() {
        // FIXME: impl
        return false;
    }

    @Override
    public ExpectationConfig getExpectations() {
        return null;
    }

    @Override
    public ErsatzConfig decoder(String contentType, BiFunction<byte[], DecodingContext, Object> decoder) {
        globalDecoders.register(contentType, decoder);
        return this;
    }

    @Override
    public ErsatzConfig decoder(ContentType contentType, BiFunction<byte[], DecodingContext, Object> decoder) {
        globalDecoders.register(contentType, decoder);
        return this;
    }

    @Override
    public ErsatzConfig encoder(String contentType, Class objectType, Function<Object, String> encoder) {
        globalEncoders.register(contentType, objectType, encoder);
        return this;
    }

    @Override
    public ErsatzConfig encoder(ContentType contentType, Class objectType, Function<Object, String> encoder) {
        globalEncoders.register(contentType, objectType, encoder);
        return this;
    }

    @Override
    public ErsatzConfig authentication(AuthenticationConfig authenticationConfig) {
        this.authenticationConfig = authenticationConfig;
        return this;
    }

    public AuthenticationConfig getAuthentication() {
        return authenticationConfig;
    }
}
