package org.fundacionjala.salesforce.ui.PageFactory;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.ClassicContactsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.LightningContactsPage;
import org.fundacionjala.salesforce.ui.pages.recycle.RecycleBinPage;
import org.fundacionjala.salesforce.ui.pages.recycle.ClassicRecycleBinPage;
import org.fundacionjala.salesforce.ui.pages.recycle.LightningRecycleBinPage;

import java.util.HashMap;
import java.util.Map;

public final class AppPageFactory {
    private static Map<String, ContactsPage> contactsPage = new HashMap<>();
    private static Map<String, RecycleBinPage> recycleBinPage = new HashMap<>();

    /**
     * Constructor.
     */
    private AppPageFactory() { }
    static {
        contactsPage.put("lighting", new LightningContactsPage());
        contactsPage.put("classic", new ClassicContactsPage());

        recycleBinPage.put("lighting", new LightningRecycleBinPage());
        recycleBinPage.put("classic", new ClassicRecycleBinPage());
    }

    /**
     * Used for select a Page.
     * @return a page.
     */
    public static ContactsPage getContactsPage() {
        return contactsPage.get(APIEnvironment.getInstance().getTypeLayout());
    }

    public static RecycleBinPage getRecycleBinPage() {
        return recycleBinPage.get(APIEnvironment.getInstance().getTypeLayout());
    }
}