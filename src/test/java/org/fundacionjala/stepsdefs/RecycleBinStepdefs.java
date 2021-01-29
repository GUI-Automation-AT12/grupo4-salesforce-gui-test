package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.utils.JsonAccount;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinPageFactory;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.fundacionjala.salesforce.ui.pages.home.HomePage;
import org.fundacionjala.salesforce.ui.pages.login.LoginPage;
import org.fundacionjala.salesforce.ui.transporter.Transporter;
import org.fundacionjala.salesforce.ui.transporter.TransporterFactory;
import org.fundacionjala.salesforce.utils.AuthenticationUtils;
import java.io.IOException;
import java.util.HashMap;
import static org.testng.Assert.assertTrue;

public class RecycleBinStepdefs {

    private ContactDetailsPage contactDetailsPage;
    private RecycleBinPage recycleBinPage = RecycleBinPageFactory.getRecycleBinPage();
    private ContactsPage contactsPage = ContactPageFactory.getContactPage();
    private Context context;

    public RecycleBinStepdefs(final Context context) {
        this.context = context;
    }

    @When("I search the Contact on Contacts page")
    public void searchTheTestContactOnContactsPage() throws IOException {
        contactsPage.searchContact(context.getContact().getFirstname());
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
        assertTrue(contactsPage.isContactInformationDisplayed((data)));
    }

    @When("I select the contact")
    public void selectTheContact() {
        contactDetailsPage = contactsPage
                .navigateToContactsDetailsPage(context.getContact().getIdContact());
    }

    @When("I delete the contact on ContactDetails page")
    public void iDeleteTheTestContactOnContactsPage() throws InterruptedException {
        Thread.sleep(2000);
        contactDetailsPage.deleteContact();

    }

    @Then("the deleted Contact should be displayed on Recycle bin page")
    public void theDeletedContactShouldBeDisplayedOnRecycleBinPage() {
        assertTrue(recycleBinPage.findRecord(JsonAccount.getInstance().getDataAsAMap("ContactTest")));
    }

    @Then("the contact information should match with the contact information on table of Recycle bin page")
    public void theContactInformationShouldMatchWithTheContactInformationOnTableOfRecycleBinPage() {
        assertTrue(recycleBinPage.isContactInformationDisplayed(
                (HashMap<String, String>) JsonAccount.getInstance().getDataAsAMap("ContactTest")));
    }
}
