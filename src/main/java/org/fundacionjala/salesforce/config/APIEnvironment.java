package org.fundacionjala.salesforce.config;

import org.fundacionjala.core.config.PropertiesFileReader;

public class APIEnvironment extends PropertiesFileReader {
    private static final String PATH_FILE = "salesforce.properties";
    private static APIEnvironment apiEnvironment = new APIEnvironment();

    /**
     * Constructor.
     */
    public APIEnvironment() {
        super(PATH_FILE);
    }

    /**
     * Initiate a single instance of PropertiesHandler, if it's possible.
     * @return the instance of PropertiesHandler object created.
     */
    public static APIEnvironment getInstance() {
        if (apiEnvironment == null) {
            apiEnvironment = new APIEnvironment();
        }
        return apiEnvironment;
    }

    /**
     * Gets the baseLoginUrl property.
     * @return baseLoginUrl from project's properties.
     */
    public String getBaseLoginUrl() {
        return super.getProperty("baseLoginUrl");
    }

    /**
     * Gets the clientId property.
     * @return clientId from project's properties.
     */
    public String getClientId() {
        return super.getProperty("clientId");
    }

    /**
     * Gets the clientSecret property.
     * @return clientSecret from project's properties.
     */
    public String getClientSecret() {
        return super.getProperty("clientSecret");
    }

    /**
     * Gets the grantType property.
     * @return grantType from project's properties.
     */
    public String getGrantType() {
        return super.getProperty("grantType");
    }

    /**
     * Gets the username property.
     * @return username from project's properties.
     */
    public String getUsername() {
        return super.getProperty("username");
    }

    /**
     * Gets the password property.
     * @return password from project's properties.
     */
    public String getPassword() {
        return super.getProperty("password");
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrl() {
        return super.getProperty("baseUrl");
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getAPIBaseUrl() {
        return super.getProperty("baseUrlAPI");
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrlClassic() {
        return super.getProperty("baseUrlClassic");
    }

    /**
     * Gets the BaseUrl from the salesforce.properties.
     * @return base url.
     */
    public String getBaseTypeLayout() {
        if (getTypeLayout().equals("lighting")) {
            return getBaseUrlLighting();
        }
        return getBaseUrlClassic();
    }

    /**
     * Gets the BaseUrl from the file.properties.
     * @return base url.
     */
    public String getBaseUrlLighting() {
        return super.getProperty("baseUrlLighting");
    }

    /**
     * Gets the typeLayout from the file.properties.
     * @return base url.
     */
    public String getTypeLayout() {
        return super.getProperty("typeLayout");
    }
}
