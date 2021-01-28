package org.fundacionjala.core.utils;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * [RH] Java script helper.
 */
public final class JavascriptHelper {
    private static WebDriver driver = WebDriverManager.getInstance().getWebDriver();
    private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    private static final int SLEEP = 1500;

    /**
     * [RH] JavascriptHelper Constructor.
     */
    private JavascriptHelper() {
    }

    /**
     * [RH] clicks an element.
     * @param webElement
     */
    public static void clickElement(final WebElement webElement) {
        try {
            Thread.sleep(SLEEP);
            javascriptExecutor.executeScript("arguments[0].click()", webElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
