package org.fundacionjala.salesforce.salesforce.utils;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WebDriverHelper {

    public WebDriverHelper() {
    }

    public static void setElement(final WebElement webElement, final String element) {
        webElement.clear();
        webElement.sendKeys(element);
    }

    public static void clickElement(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Clicks an by.
     * @param by
     */
    public static void clickElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        clickElement(webElement);
    }

    /**
     * returns  an by.
     * @param by
     */
    public static WebElement searchElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        return webElement;
    }

    /**
     * Method wait to load a webElement.
     * @param webElement
     */
    public static void waitUntil(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static String getTextElement(final WebElement webElement) {
        return webElement.getText();
    }

}
