package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.utils.JsonAccount;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.PageFactory.AppPageFactory;
import org.fundacionjala.salesforce.ui.pages.Init.InitialPage;
import org.fundacionjala.salesforce.ui.pages.contactDetailsPage.ContactDetailsAbstractPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsAbstractPage;
import org.fundacionjala.salesforce.ui.pages.home.HomePage;
import org.fundacionjala.salesforce.ui.pages.login.LoginPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinAbstractPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import java.io.IOException;
import java.util.HashMap;
import static org.testng.Assert.assertTrue;

public class RecycleBinStepdefs {

    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private ContactDetailsAbstractPage contactDetailsAbstractPage;
    private RecycleBinAbstractPage recycleBinAbstractPage = AppPageFactory.getRecycleBinPage();
    private ContactsAbstractPage contactsAbstractPage = AppPageFactory.getContactsPage();
    private Context context;

    public RecycleBinStepdefs(final Context context) {
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

    @When("I search the Contact on Contacts page")
    public void searchTheTestContactOnContactsPage() throws IOException {
        contactsAbstractPage.searchContact(context.getContact().getFirstname());
    }

    @Then("the contact information should match with the contact information on table of Contacts page")
    public void verifyContactInformationShouldMatchWithTheContactInformationOnTable() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Firstname", context.getContact().getFirstname());
        data.put("Lastname" , context.getContact().getLastName());
        data.put("Account Name", context.getAccount().getName());
        data.put("Account Site", context.getAccount().getSite());
        data.put("Phone", context.getContact().getPhone());
        data.put("Email", context.getContact().getEmail());
        assertTrue(contactsAbstractPage.isContactInformationDisplayed((data)));
    }

    @When("I select the contact")
    public void selectTheContact() {
        contactDetailsAbstractPage = contactsAbstractPage
                .navigateToContactsDetailsPage(context.getContact().getIdContact());
    }

    @When("I delete the contact on ContactDetails page")
    public void iDeleteTheTestContactOnContactsPage() {
        contactDetailsAbstractPage.deleteContact();

    }

    @Then("the deleted Contact should be displayed on Recycle bin page")
    public void theDeletedContactShouldBeDisplayedOnRecycleBinPage() {
        assertTrue(recycleBinAbstractPage.findRecord(JsonAccount.getInstance().getDataAsAMap("ContactTest")));
    }

    @And("the contact information should match with the contact information on table of Recycle bin page")
    public void theContactInformationShouldMatchWithTheContactInformationOnTableOfRecycleBinPage() {
        assertTrue(recycleBinAbstractPage.isContactInformationDisplayed(
                (HashMap<String, String>) JsonAccount.getInstance().getDataAsAMap("ContactTest")));
    }
}
