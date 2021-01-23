package org.fundacionjala.salesforce.ui.transporter;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.config.APIEnvironment;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public abstract  class TransporterPage {
    private static Transporter trans = TransporterFactory.getTransporter(APIEnvironment.getInstance().getTypeLayout());
    private static Map<String, String> pageUrl = trans.getPageUrl();

    /**
     * [JS] Constructor.
     */
    private TransporterPage() { }

    /**
     * [JS] Navigates to url.
     * @param url
     * @throws MalformedURLException
     */
    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }

    /**
     * [JS] Navigates to a page.
     * @param pageName
     * @throws MalformedURLException
     */
    public static void navigateToPage(final String pageName) throws Exception {
        navigateToUrl(APIEnvironment.getInstance().getBaseTypeLayout().concat(pageUrl.get(pageName)));


    }

    /**
     * [JS] Navigates to a base page.
     */
    public static void navigateToBaseUrl() {
        WebDriverManager.getInstance().getWebDriver().get(APIEnvironment.getInstance().getBaseUrl());
    }

    /**
     * [JS] Refresh the page.
     */
    public static void refreshPage() {
        WebDriverManager.getInstance().getWebDriver().navigate().refresh();
    }
}
