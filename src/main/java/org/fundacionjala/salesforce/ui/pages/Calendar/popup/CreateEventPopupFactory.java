package org.fundacionjala.salesforce.ui.pages.Calendar.popup;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class CreateEventPopupFactory extends BasePage {

    private static Map<String, CreateEventPopup> contactMap = new HashMap<>();
    static {
        contactMap.put("lightning", new LightningCreateEventPopup());
        contactMap.put("classic", new ClassicCreateEventPopup());
    }

    /**
     * Gets a Abstract CreateEventPopup class.
     * @return a CreateEventPopup.
     */
    public static CreateEventPopup getContactPage() {
        return contactMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
