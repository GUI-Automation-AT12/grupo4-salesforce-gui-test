package org.fundacionjala.salesforce.utils;

import org.fundacionjala.core.utils.ReaderPropertiesFile;

public class APIPropertiesEnvironment extends ReaderPropertiesFile {
    private static final String PATH_FILE = "gradle.properties";
    private static APIPropertiesEnvironment apiPropertiesEnvironment = new APIPropertiesEnvironment();

    /**
     * Constructor.
     */
    public APIPropertiesEnvironment() {
        super(PATH_FILE);
    }

    /**
     * Initiate a single instance of PropertiesHandler, if it's possible.
     * @return the instance of PropertiesHandler object created.
     */
    public static APIPropertiesEnvironment getInstance() {
        if (apiPropertiesEnvironment == null) {
            apiPropertiesEnvironment = new APIPropertiesEnvironment();
        }
        return apiPropertiesEnvironment;
    }

    /**
     * Gets the baseLoginUrl property.
     * @return baseLoginUrl from project's properties.
     */
    public String getBaseLoginUrl() {
        return super.getEnvProperty("baseLoginUrl");
    }

    /**
     * Gets the clientId property.
     * @return clientId from project's properties.
     */
    public String getClientId() {
        return super.getEnvProperty("clientId");
    }

    /**
     * Gets the clientSecret property.
     * @return clientSecret from project's properties.
     */
    public String getClientSecret() {
        return super.getEnvProperty("clientSecret");
    }

    /**
     * Gets the grantType property.
     * @return grantType from project's properties.
     */
    public String getGrantType() {
        return super.getEnvProperty("grantType");
    }

    /**
     * Gets the username property.
     * @return username from project's properties.
     */
    public String getUsername() {
        return super.getEnvProperty("username");
    }

    /**
     * Gets the password property.
     * @return password from project's properties.
     */
    public String getPassword() {
        return super.getEnvProperty("password");
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrl() {
        return getEnvProperty("baseUrl");
    }
}
