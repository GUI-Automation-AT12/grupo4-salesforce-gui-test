package org.fundacionjala.core.config;

public final class ExecuteProperties {

    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static ExecuteProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it creates a new one, otherwise returns the created.
     * @return singleInstance
     */
    public static ExecuteProperties getInstance() throws RuntimeException {
        if (singleInstance == null) {
            singleInstance = new ExecuteProperties();
        }
        return singleInstance;
    }

    private ExecuteProperties() throws RuntimeException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }

    /**
     * Gets the cucumberThreadCount from the properties file.
     * @return cucumberThreadCount value
     */
    public String getCucumberThreadCount() {
        return propertiesFileReader.getProperty("cucumberThreadCount");
    }

    /**
     * Gets the filterTags from the properties file.
     * @return filterTags value
     */
    public String getFilterTags() {
        return propertiesFileReader.getProperty("filterTags");
    }

    /**
     * Gets the testBrowser from the properties file.
     * @return testBrowser value
     */
    public String getTestBrowser() {
        return propertiesFileReader.getProperty("testBrowser");
    }

}
