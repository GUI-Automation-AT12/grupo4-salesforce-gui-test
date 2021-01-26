package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.salesforce.ui.pages.BasePage;

public abstract class ContactsPage extends BasePage {

    public abstract void setSearch(final String contact);

    public abstract void searchContact(final String contact);

    public abstract void findContact(String contact);

    public abstract void selectContact(final String id);

    public abstract String getContactName(final String id);

}
