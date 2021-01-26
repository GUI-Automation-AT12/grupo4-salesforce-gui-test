package org.fundacionjala.salesforce.ui.PageFactory;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsAbstractPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsClassicPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsLightningPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinAbstractPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinClassicPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinLightningPage;

import java.util.HashMap;
import java.util.Map;

public final class AppPageFactory {
    private static Map<String, ContactsAbstractPage> contactsPage = new HashMap<>();
    private static Map<String, RecycleBinAbstractPage> recycleBinPage = new HashMap<>();

    /**
     * Constructor.
     */
    private AppPageFactory() { }
    static {
        contactsPage.put("lighting", new ContactsLightningPage());
        contactsPage.put("classic", new ContactsClassicPage());

        recycleBinPage.put("lighting", new RecycleBinLightningPage());
        recycleBinPage.put("classic", new RecycleBinClassicPage());

    }

    /**
     * Used for select a Page.
     * @return a page.
     */
    public static ContactsAbstractPage getContactsPage() {
        return contactsPage.get(APIEnvironment.getInstance().getTypeLayout());
    }

    public static RecycleBinAbstractPage getRecycleBinPage() {
        return recycleBinPage.get(APIEnvironment.getInstance().getTypeLayout());
    }
}