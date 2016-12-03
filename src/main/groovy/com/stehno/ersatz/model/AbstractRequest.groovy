/**
 * Copyright (C) 2016 Christopher J. Stehno
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
package com.stehno.ersatz.model

import com.stehno.ersatz.Request
import com.stehno.ersatz.Response
import com.stehno.ersatz.Verifiers
import groovy.transform.CompileStatic
import io.undertow.server.HttpServerExchange
import io.undertow.server.handlers.Cookie
import io.undertow.util.HeaderMap

import java.util.function.Consumer
import java.util.function.Function

/**
 * Abstract base class for request expectation definitions.
 */
@CompileStatic
abstract class AbstractRequest implements Request {

    private final Map<String, List<String>> queryParams = new HashMap<>()
    private final Map<String, String> headers = new HashMap<>()
    private final Map<String, String> cookies = new HashMap<>()
    private final List<Consumer<Request>> listeners = new LinkedList<>()
    private final List<Response> responses = new LinkedList<>()
    private final List<Function<Request, Boolean>> conditions = new LinkedList<>()
    private final String path
    private Function<Integer, Boolean> verifier = Verifiers.any()
    private int callCount

    AbstractRequest(final String path) {
        this.path = path
    }

    Request header(final String name, final String value) {
        headers.put(name, value)
        return this
    }

    String header(final String name) {
        return headers.get(name)
    }

    Request contentType(final String contentType) {
        header("Content-Type", contentType)
        return this
    }

    Request query(final String name, final String value) {
        queryParams.computeIfAbsent(name, { k -> new ArrayList<>() }).add(value)
        return this
    }

    List<String> query(final String name) {
        return Collections.unmodifiableList(queryParams.get(name))
    }

    Request cookie(final String name, final String value) {
        cookies.put(name, value)
        return this
    }

    String cookie(final String name) {
        return cookies.get(name)
    }

    Request listener(final Consumer<Request> listener) {
        listeners.add(listener)
        return this
    }

    Response responds() {
        Response response = newResponse()
        responses.add(response)
        return response
    }

    Request responder(final Consumer<Response> responder) {
        Response response = newResponse()
        responder.accept(response)
        responses.add(response)
        return this
    }

    Request responder(final Closure closure) {
        Response response = newResponse()
        closure.setDelegate(response)
        closure.call()

        responses.add(response)

        return this
    }

    Request condition(final Function<Request, Boolean> matcher) {
        conditions.add(matcher)
        return this
    }

    Request verifier(final Function<Integer, Boolean> verifier) {
        this.verifier = verifier
        return this
    }

    boolean verify() {
        return verifier.apply(callCount)
    }

    boolean matches(final HttpServerExchange exchange) {
        return exchange.getRequestPath() == path &&
            (conditions.empty || conditions.every { it.apply(this) }) &&
            matchQueryParams(exchange.queryParameters) &&
            containsHeaders(exchange.requestHeaders) &&
            containsCookies(exchange.requestCookies)
    }

    protected abstract Response newResponse()

    // header matching is not absolute - the request must contain the specified headers but not necessarily all of them
    // TODO: needs to support more complicated headers
    private boolean containsHeaders(final HeaderMap requestHeads) {
        headers.every { k, v -> v == requestHeads.getFirst(k) }
    }

    private boolean containsCookies(final Map<String, Cookie> requestCookies) {
        cookies.every { k, v -> requestCookies.containsKey(k) && v == requestCookies.get(k).value }
    }

    private boolean matchQueryParams(final Map<String, Deque<String>> requestQs) {
        boolean one = queryParams.every { k, v ->
            requestQs.containsKey(k) && requestQs.get(k).containsAll(v)
        }
        boolean two = requestQs.every { k, v ->
            queryParams.containsKey(k) && queryParams.get(k).containsAll(v)
        }
        return one && two
    }

    // TODO: see if this can be package
    void respond(final HttpServerExchange exchange) {
        ContentResponse response = (ContentResponse) responses.get(callCount >= responses.size() ? responses.size() - 1 : callCount)
        mark()

        response.send(exchange)
    }

    private void mark() {
        callCount++

        for (final Consumer<Request> listener : listeners) {
            listener.accept(this)
        }
    }
}