package org.fundacionjala.core.selenium.browsers;

import org.openqa.selenium.WebDriver;

/**
 * [JS]Interface that init the Driver
 */
public interface IBrowser {
    /**
     * Initializes a new webDriver for browser.
     * @return WebDriver
     */
    WebDriver initDriver();
}
