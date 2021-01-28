package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.Init.InitialPage;
import org.fundacionjala.salesforce.ui.pages.home.HomePage;
import org.fundacionjala.salesforce.ui.pages.login.LoginPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;

public class BackgroundStepdefs {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private Context context;

    public BackgroundStepdefs(final Context context) {
        this.context = context;
    }

    @Given("^I log in Salesforce with (.*?) User credentials$")
    public void logInTrelloWithValidCredentials(final String typeUser) throws Exception {
        TransporterPage.navigateToBaseUrl();
        initialPage = new InitialPage();
        loginPage = initialPage.goToLogin();
        loginPage.waitUntilPageIsLoaded();
        homePage = loginPage.login(APIEnvironment.getInstance().getUsername(),
                APIEnvironment.getInstance().getPassword());
    }

    @When("^I navigate to (.*?) page$")
    public void navigateToContactsPage(final String page) throws Exception {
        TransporterPage.navigateToPage(page);
    }

}
