package org.fundacionjala.salesforce.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.entity.ContentType;

public final class AuthenticationUtils {
    private static final String BASE_LOGIN_URL = APIPropertiesEnvironment.getInstance().getBaseLoginUrl();
    private static final String BASE_URL = APIPropertiesEnvironment.getInstance().getBaseUrl();
    private static final String PATH = "services/oauth2/token";
    private static final String GRANT_TYPE_KEY = "grant_type";
    private static final String GRANT_TYPE_VAL = APIPropertiesEnvironment.getInstance().getGrantType();
    private static final String CLIENT_ID_KEY = "client_id";
    private static final String CLIENT_ID_VAL = APIPropertiesEnvironment.getInstance().getClientId();
    private static final String CLIENT_SECRET_KEY = "client_secret";
    private static final String CLIENT_SECRET_VAL = APIPropertiesEnvironment.getInstance().getClientSecret();
    private static final String USERNAME_KEY = "username";
    private static final String USERNAME_VAL = APIPropertiesEnvironment.getInstance().getUsername();
    private static final String PASSWORD_KEY = "password";
    private static final String PASSWORD_VAL = APIPropertiesEnvironment.getInstance().getPassword();

    /**
     * Private secure Constructor.
     */
    private AuthenticationUtils() {
    }

    /**
     * It try to get the credentials from salesforce, sending a request for that purpose.
     * @return the authentication response from salesforce.
     */
    private static Response sendAuthenticationRequest() {
        RestAssured.baseURI = BASE_LOGIN_URL;
        Response response = RestAssured
                .given()
                .param(GRANT_TYPE_KEY, GRANT_TYPE_VAL)
                .param(CLIENT_ID_KEY, CLIENT_ID_VAL)
                .param(CLIENT_SECRET_KEY, CLIENT_SECRET_VAL)
                .param(USERNAME_KEY, USERNAME_VAL)
                .param(PASSWORD_KEY, PASSWORD_VAL)
                .when()
                .post(PATH);
        return response;
    }

    /**
     * Get request specifications and set main headers to build the request to send.
     * @return the request built.
     */
    public static RequestSpecification getLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        Response response = sendAuthenticationRequest();
        String instanceUrl = response.jsonPath().getString("instance_url");
        String baseUrl = instanceUrl + BASE_URL;
        String accessToken = response.jsonPath().getString("access_token");
        request.baseUri(baseUrl);
        request.auth().oauth2(accessToken);
        request.contentType(ContentType.APPLICATION_JSON.toString());
        return request;
    }

    /**
     * Get request specifications to send a request as an unauthorized user.
     * @return the request built.
     */
    public static RequestSpecification getNotLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        String instanceUrl = sendAuthenticationRequest().jsonPath().getString("instance_url");
        String baseUrl = instanceUrl + BASE_URL;
        request.baseUri(baseUrl);
        return request;
    }

    /**
     * Get request specifications to send a request as an unauthorized user.
     * @return the request built.
     */
    public static String getInstanceUrl() {
        Response response = sendAuthenticationRequest();
        String instanceUrl = response.jsonPath().getString("instance_url");
        return instanceUrl;
    }
}
