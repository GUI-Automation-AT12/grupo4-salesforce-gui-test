package org.fundacionjala.salesforce.ui.pages.tasks;

import org.fundacionjala.salesforce.config.APIEnvironment;
import java.util.HashMap;
import java.util.Map;

public class TaskPageFactory {
    private static Map<String, TaskPage> contactDetailsMap = new HashMap<>();
    static {
        contactDetailsMap.put("lightning", new LightningTaskPage());
        contactDetailsMap.put("classic", new ClassicTaskPage());
    }

    /**
     * Gets a Abstract Task class.
     * @return a TaskPage.
     */
    public static TaskPage getContactDetailsPage() {
        return contactDetailsMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
