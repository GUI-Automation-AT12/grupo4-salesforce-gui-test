package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonHooks {

    /**
     * Take screenShoot after each failed scenario.
     * @param scenario
     */
    @After
    public void takeScreenshot(final Scenario scenario) {
        String screensHostName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.getInstance().getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screensHostName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
