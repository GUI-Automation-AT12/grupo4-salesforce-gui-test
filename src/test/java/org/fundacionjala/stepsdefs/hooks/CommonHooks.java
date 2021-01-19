package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;

public class CommonHooks {

    @After
    public void close() {
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
