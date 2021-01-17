package org.fundacionjala.salesforce.ui.pages.Init;


import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep2Page extends BasePage {
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(name = "action")
    private WebElement signInBtn;

    private void fillPassword(final String password) {
        WebDriverHelper.setElement(passwordTextBox, password);
    }

    private void clickSignInBtn() {
        WebDriverHelper.clickElement(signInBtn);
    }


}
