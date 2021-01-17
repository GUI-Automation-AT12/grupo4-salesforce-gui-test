package org.fundacionjala.core.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class RequestManager {

    private static RequestSpecification requestSpec;

    /**
     * Constructor for the Request Manager.
     */
    private RequestManager() {

    }

    /**
     * Sets request spec.
     *
     * @param reqSpec
     */
    public static void setRequestSpec(final RequestSpecification reqSpec) {
        requestSpec = reqSpec;
    }

    /**
     * Sets custom headers.
     *
     * @param headers
     */
    public static void setHeaders(final Map<String, String> headers) {
        requestSpec.headers(headers);
    }

    /**
     * Makes a GET request.
     *
     * @param endpoint
     * @return a response object.
     */
    public static Response get(final String endpoint) {
        return given().spec(requestSpec).when().get(endpoint);
    }

    /**
     * Makes POST request.
     *
     * @param endpoint
     * @param body
     * @return a response object.
     */
    public static Response post(final String endpoint, final String body) {
        return given().spec(requestSpec).body(body).when().post(endpoint);
    }

    /**
     * Makes a PUT request.
     *
     * @param endpoint
     * @param put
     * @return a response object.
     */
    public static Response put(final String endpoint, final String put) {
        return given().spec(requestSpec).body(put).when().put(endpoint);
    }

    /**
     * Makes a PATCH request.
     *
     * @param endpoint
     * @param patch
     * @return a response object.
     */
    public static Response patch(final String endpoint, final String patch) {
        return given().spec(requestSpec).body(patch).when().patch(endpoint);
    }

    /**
     * Makes a DELETE request.
     *
     * @param endpoint
     * @return a response object.
     */
    public static Response delete(final String endpoint) {
        return given().spec(requestSpec).when().delete(endpoint);
    }
}
