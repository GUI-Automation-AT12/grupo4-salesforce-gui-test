package org.fundacionjala.core.selenium;

import org.fundacionjala.core.selenium.browsers.Chrome;
import org.fundacionjala.core.selenium.browsers.Edge;
import org.fundacionjala.core.selenium.browsers.Firefox;
import org.fundacionjala.core.selenium.browsers.IBrowser;
import org.fundacionjala.core.utils.JsonBrowser;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class BrowserFactory {

    /**
     * Constructor for the BrowserFactory class.
     */
    private BrowserFactory() {
    }

    private static Map<String, IBrowser> browsersMap = new HashMap<>();
    static {
        browsersMap.put("chrome", new Chrome());
        browsersMap.put("firefox", new Firefox());
        browsersMap.put("edge", new Edge());
    }

    /**
     * Gets a webDriver providing its name.
     * @param browserName name of the browser
     * @return a webDriver
     */
    public static WebDriver getWebDriver(final String browserName) {
        return browsersMap.get(browserName).initDriver();
    }

    /**
     * Gets a driverProps providing the browser name.
     * @param browserName name of the browser
     * @return Driver Properties of the browser
     * @thows IOException
     */
    public static Browser getDriverProps(final String browserName) throws IOException {
        return JsonBrowser.getBrowsersMap().get(browserName);
    }
}
