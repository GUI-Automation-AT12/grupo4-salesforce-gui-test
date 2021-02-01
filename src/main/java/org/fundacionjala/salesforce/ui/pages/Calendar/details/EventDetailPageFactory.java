package org.fundacionjala.salesforce.ui.pages.Calendar.details;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.Calendar.CalendarPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.ClassicCalendarPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.LightningCalendarPage;

import java.util.HashMap;
import java.util.Map;

public class EventDetailPageFactory extends BasePage {

    private static Map<String, EventDetailPage> contactMap = new HashMap<>();
    static {
        contactMap.put("lightning", new LightningEventDetailPage());
        contactMap.put("classic", new ClassicEventDeatilPage());
    }

    /**
     * Gets a Abstract class.
     * @return a Page.
     */
    public static EventDetailPage getContactPage() {
        return contactMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
