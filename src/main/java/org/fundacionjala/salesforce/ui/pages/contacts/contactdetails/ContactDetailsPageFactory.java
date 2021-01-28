package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import java.util.HashMap;
import java.util.Map;

/**
 * [RH].
 */
public class ContactDetailsPageFactory extends BasePage {

    /**
     * Constructor.
     */
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
