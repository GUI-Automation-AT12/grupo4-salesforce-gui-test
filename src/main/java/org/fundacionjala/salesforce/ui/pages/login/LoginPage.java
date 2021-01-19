package org.fundacionjala.salesforce.ui.pages.login;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.home.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameOrEmailTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "Login")
    private WebElement btnLogin;

    private void fillUsernameOrEmail(final String usernameOrEmail) {
        WebDriverHelper.setElement(usernameOrEmailTextBox, usernameOrEmail);
    }

    private void fillPassword(final String password) {
        WebDriverHelper.setElement(passwordTextBox, password);
    }

    private void clickNextBtn() {
        WebDriverHelper.clickElement(btnLogin);
    }

    /**
     * Allows to fill usernameOrEmail credential to log in Pivotal Tracker driving to Login Step 2 Page.
     * @param username
     * @param password
     * @return a new LoginStep2Page;
     */
    public HomePage login(final String username, final String password) {
        fillUsernameOrEmail(username);
        fillPassword(password);
        clickNextBtn();
        return new HomePage();
    }

    public void waitUntilPageIsLoaded(){
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(usernameOrEmailTextBox));
    }
}
