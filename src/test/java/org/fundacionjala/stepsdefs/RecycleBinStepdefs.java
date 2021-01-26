package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.Init.InitialPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.fundacionjala.salesforce.ui.pages.home.HomePage;
import org.fundacionjala.salesforce.ui.pages.login.LoginPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.fundacionjala.salesforce.utils.AuthenticationUtils;

import java.io.IOException;
import java.net.MalformedURLException;

public class RecycleBinStepdefs {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private Context context;
    private ContactsPage contactsPage;

    public RecycleBinStepdefs(final Context context) {
        this.context = context;
    }

    @Given("^I log in Salesforce with (.*?) User credentials$")
    public void logInTrelloWithValidCredentials(final String typeUser) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().get("https://www.salesforce.com/");
        initialPage = new InitialPage();
        loginPage = initialPage.goToLogin();
        loginPage.waitUntilPageIsLoaded();
        homePage = loginPage.login(APIEnvironment.getInstance().getUsername(),
                APIEnvironment.getInstance().getPassword());
    }

    @When("I navigate to Contacts page")
    public void iNavigateToContactsPage() throws Exception {
        TransporterPage.navigateToPage("Contacts");
    }

    @And("I search the Test Contact on Contacts page")
    public void searchTheTestContactOnContactsPage() throws IOException {
        contactsPage = ContactPageFactory.getContactPage();
        Response response = RequestManager.get("contact/" + context.getValueData("id"));
        context.saveData(response.asString());
        contactsPage.searchContact(context.getValueData("FirstName"));
        //contactsPage.findContact(context.getValueData("FirstName") + " " + context.getValueData("LastName"));
    }

    @And("I delete the Test Contact on Contacts page")
    public void iDeleteTheTestContactOnContactsPage() {

    }

    @And("I navigate to Recycle Bin page")
    public void iNavigateToRecycleBinPage() {
    }

    @Then("the deleted Contact should be displayed on Recycle bin page")
    public void theDeletedContactShouldBeDisplayedOnRecycleBinPage() {
    }

    @And("the contact information should match with the contact information on table of Recycle bin page")
    public void theContactInformationShouldMatchWithTheContactInformationOnTableOfRecycleBinPage() {
    }

    @And("I delete the created Contact on Contacts page")
    public void iDeleteTheCreatedContactOnContactsPage() {

    }

    @And("the contact deleted date should match with the time of the deleted element")
    public void theContactDeletedDateShouldMatchWithTheTimeOfTheDeletedElement() {
    }

}
