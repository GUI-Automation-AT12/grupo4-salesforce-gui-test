package org.fundacionjala.salesforce.ui.pages.Init;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.login.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(css = "div[aria-label='Login'] a[href*='login']")
    private WebElement logInLink;

    private void clickLogInLink() {
        WebDriverHelper.clickElement(logInLink);
    }


    /**
     * Allows to go to Login Step 1 Page from GUI.
     * @return a new LoginStep1Page.
     */
    public LoginPage goToLogin() {
        clickLogInLink();
        return new LoginPage();
    }

}
