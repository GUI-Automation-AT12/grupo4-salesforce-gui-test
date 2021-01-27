package org.fundacionjala.core.utils;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class JavascriptHelper {
    private static WebDriver driver = WebDriverManager.getInstance().getWebDriver();
    private static JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
    /**
     *
     */
    private JavascriptHelper() {
    }

    /**
     *  clicks an element.
     * @param webElement
     */
    public static void clickElement(final WebElement webElement) {
        try {
            Thread.sleep(1500);
            javascriptExecutor.executeScript("arguments[0].click()", webElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
