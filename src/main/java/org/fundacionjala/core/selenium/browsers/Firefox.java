package org.fundacionjala.core.selenium.browsers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
/**
 * [JS]returns the FirefoxDriver from BoniGarcia Library.
 */
public class Firefox implements IBrowser {

    /**
     * Initializes Firefox driver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("73.0.1").setup();
        return new FirefoxDriver();
    }
}
