package org.fundacionjala.salesforce.ui.pages;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Constructor.
     */
    protected BasePage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Gets webDriver.
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets webDriverWait.
     * @return
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
