package org.fundacionjala.salesforce.ui.pages.contacts.details;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Map;

public class ContactDetailsPageFactory extends BasePage {

    public ContactDetailsPageFactory() {

    }

    private static Map<String, ContactDetailsPage> contactDetailsMap = new HashMap<>();
    static {
        contactDetailsMap.put("lightning", new LightningContactDetailPage());
        contactDetailsMap.put("classic", new ClassicContactDetailsPage());
    }

    /**
     * Gets a Abstract ContactDetails class.
     * @return a ContactDetailsPage.
     */
    public static ContactDetailsPage getContactDetailsPage() {
        return contactDetailsMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
