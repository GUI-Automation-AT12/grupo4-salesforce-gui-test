package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class ContactPageFactory extends BasePage {

    private static Map<String, ContactsPage> contactMap = new HashMap<>();
    static {
        contactMap.put("lightning", new LightningContactsPage());
        contactMap.put("classic", new ClassicContactsPage());
    }

    /**
     * Gets a Abstract ContactDetails class.
     * @return a ContactDetailsPage.
     */
    public static ContactsPage getContactPage() {
        return contactMap.get(APIEnvironment.getInstance().getSkin());
    }
}
