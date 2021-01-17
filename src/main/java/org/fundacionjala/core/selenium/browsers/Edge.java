package org.fundacionjala.core.selenium.browsers;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;

/**
 * [JS]returns the EdgeDriver from BoniGarcia Library.
 */
public class Edge implements IBrowser {

    /**
     * Initializes Edge driver.
     */
    @Override
    public WebDriver initDriver() {
        EdgeDriverManager.getInstance(EDGE).version("87.0.664.66").setup();
        return new EdgeDriver();
    }
}
