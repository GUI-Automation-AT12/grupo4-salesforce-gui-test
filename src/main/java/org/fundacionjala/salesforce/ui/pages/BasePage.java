package org.fundacionjala.salesforce.ui.pages;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    /**
     * Constructor.
     */
    protected BasePage() {
        driver = WebDriverManager.getInstance().getWebDriver();
        javascriptExecutor = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     *
     *
     * @return JavascriptExecutor
     */
    public WebDriver getJavaScriptExecutor() {
        return javascriptExecutor;
    }
}
