package com.stehno.ersatz.config;

import com.stehno.ersatz.Authentication;

import static com.stehno.ersatz.Authentication.BASIC;
import static com.stehno.ersatz.Authentication.DIGEST;

public class AuthenticationConfigImpl implements AuthenticationConfig {

    private String username = "admin";
    private String password = "$3cr3t";
    private Authentication type;

    @Override
    public void setUsername(String value) {
        this.username = value;
    }

    @Override
    public void setPassword(String value) {
        this.password = value;
    }

    @Override
    public void setType(Authentication type) {
        this.type = type;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Authentication getType() {
        return type;
    }

    @Override
    public void basic() {
        basic(null, null);
    }

    @Override
    public void basic(String username) {
        basic(username, null);
    }

    /**
     * Configures BASIC authentication support.
     *
     * @param username the username or null to use the default
     * @param password the password or null to use the default
     */
    @Override
    public void basic(final String username, final String password) {
        spec(BASIC, username, password);
    }

    @Override
    public void digest() {
        digest(null, null);
    }

    @Override
    public void digest(String username) {
        digest(username, null);
    }

    /**
     * Configures DIGEST authentication support.
     *
     * @param username the username or null to use the default
     * @param password the password or null to use the default
     */
    @Override
    public void digest(final String username, final String password) {
        spec(DIGEST, username, password);
    }

    private void spec(final Authentication type, final String username, final String password) {
        this.type = type;
        if (username != null) {
            this.username = username;
        }
        if (password != null) {
            this.password = password;
        }
    }
}