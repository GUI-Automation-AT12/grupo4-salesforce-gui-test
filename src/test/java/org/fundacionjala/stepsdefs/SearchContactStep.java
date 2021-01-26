package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.testng.asserts.SoftAssert;

public class SearchContactStep {

    private Context context;
    ContactsPage contactsPage;
    public SearchContactStep(final Context context) {
        this.context = context;
    }
    @Then("the searched contact should be displayed on contacts page")
    public void shouldBeDisplayedOnContactsPage() {
        contactsPage = ContactPageFactory.getContactPage();
        contactsPage.selectContact(context.getValueData("Id"));
    }

    @And("I validate the information of the searched contact")
    public void iValidateTheInformationOfTheSearchedContact() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(context.getValueData("FirstName"),contactsPage.getContactName(context.getValueData("FirstName") + " " + context.getValueData("LastName") ));
    }
}
