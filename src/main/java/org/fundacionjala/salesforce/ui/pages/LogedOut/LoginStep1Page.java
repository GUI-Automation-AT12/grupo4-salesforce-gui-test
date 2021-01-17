package org.fundacionjala.salesforce.ui.pages.LogedOut;


import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep1Page extends BasePage {
    @FindBy(id = "credentials_username")
    private WebElement usernameOrEmailTextBox;

    @FindBy(name = "action")
    private WebElement nextBtn;

    private void fillUsernameOrEmail(final String usernameOrEmail) {
        WebDriverHelper.setElement(usernameOrEmailTextBox, usernameOrEmail);
    }

    private void clickNextBtn() {
        WebDriverHelper.clickElement(nextBtn);
    }

    /**
     * Allows to fill usernameOrEmail credential to log in Pivotal Tracker driving to Login Step 2 Page.
     * @param usernameOrEmail username or email of the user
     * @return a new LoginStep2Page;
     */
    public LoginStep2Page goToLoginStep2(final String usernameOrEmail) {
        fillUsernameOrEmail(usernameOrEmail);
        clickNextBtn();
        return new LoginStep2Page();
    }
}
