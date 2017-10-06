/*
 * Copyright (C) 2017 Christopher J. Stehno
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stehno.ersatz.config;

import com.stehno.ersatz.Authentication;

/**
 * Configuration object for BASIC and DIGEST authentication support. If the username or password are unspecified or null, they will be "admin" and
 * "$3cr3t" respectively.
 * <p>
 * Only one of BASIC or DIGEST may be specified (last one called wins).
 * <p>
 * Enabling authentication causes ALL server endpoints to require the configured authentication.
 */
public interface AuthenticationConfig {

    /**
     * The configured username. Defaults to "admin".
     */
    void setUsername(String value);

    /**
     * The configured password. Defaults to "$3cr3t".
     */
    void setPassword(String value);

    /**
     * The configured authentication type.
     */
    void setType(Authentication type);


    String getUsername();

    String getPassword();

    Authentication getType();

    void basic();

    void basic(String username);

    /**
     * Configures BASIC authentication support.
     *
     * @param username the username or null to use the default
     * @param password the password or null to use the default
     */
    void basic(String username, String password);

    void digest();

    void digest(String username);

    /**
     * Configures DIGEST authentication support.
     *
     * @param username the username or null to use the default
     * @param password the password or null to use the default
     */
    void digest(String username, String password);
}

