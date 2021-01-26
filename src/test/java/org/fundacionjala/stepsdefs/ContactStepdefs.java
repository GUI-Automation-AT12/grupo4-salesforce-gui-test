package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;

import java.io.IOException;

public class ContactStepdefs {

    private Context context;

    public ContactStepdefs(final Context context) {
        this.context = context;
    }

    @And("I search for the created contact")
    public void iSearchForTheCreatedContact() throws IOException {
        ContactsPage contactsPage = ContactPageFactory.getContactPage();
        contactsPage.searchContact(context.getValueData("FirstName"));
        contactsPage.findContactInTable(context.getValueData("Id"));
    }
}
