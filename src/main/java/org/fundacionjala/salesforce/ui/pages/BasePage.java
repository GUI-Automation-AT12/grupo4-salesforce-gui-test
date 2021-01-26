package org.fundacionjala.salesforce.ui.pages;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;

    /**
     * Constructor.
     */
    protected BasePage() {
        driver = WebDriverManager.getInstance().getWebDriver();
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
}
