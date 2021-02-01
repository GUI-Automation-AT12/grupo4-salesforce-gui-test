package org.fundacionjala.core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * [RH] Web driver helper class.
 */
public final class WebDriverHelper {
    /**
     *
     */
    private WebDriverHelper() {
    }

    /**
     * sets an element.
     * @param webElement
     * @param element
     */
    public static void setElement(final WebElement webElement, final String element) {
        webElement.clear();
        webElement.sendKeys(element);
    }

    /**
     *  clicks an element.
     * @param webElement
     */
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
     * @return  an WebElement.
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

    /**
     * @return get text from an element.
     * @param webElement
     */
    public static String getTextElement(final WebElement webElement) {
        return webElement.getText();
    }

    /**
     * Waits until an element is displayed.
     * @param element
     */
    public static void waitUntilIsVisible(final WebElement element) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Gets value of WebElement.
     * @param webElement
     * @return value of WebElement
     */
    public static String getValue(final WebElement webElement) {
        return webElement.getAttribute("value");
    }

    /**
     * [JS]Method to Select an item from a selectBox by value.
     * @param webElement
     * @param value
     */
    public static void selectItemByValue(final WebElement webElement, final String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }
    /**
     * [Js] Change to the Iframe.
     * @param webElement of the an iframe
     */

    public static void frameToBeAvailableAndSwitchToIt(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriver().switchTo().defaultContent();
        WebDriverManager.getInstance().getWebDriverWait()
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }
}
