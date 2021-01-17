package org.fundacionjala.core.selenium.browsers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * [JS]returns the ChromeDriver from BoniGarcia Library.
 */
public class Chrome implements IBrowser {

    /**
     * @return webDriver Chrome.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
