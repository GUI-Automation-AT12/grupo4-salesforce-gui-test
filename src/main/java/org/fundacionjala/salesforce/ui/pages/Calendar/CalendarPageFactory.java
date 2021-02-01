package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class CalendarPageFactory extends BasePage {

    private static Map<String, CalendarPage> contactMap = new HashMap<>();
    static {
        contactMap.put("lightning", new LightningCalendarPage());
        contactMap.put("classic", new ClassicCalendarPage());
    }

    /**
     * Gets a Abstract Calendar class.
     * @return a Calendar.
     */
    public static CalendarPage getContactPage() {
        return contactMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
