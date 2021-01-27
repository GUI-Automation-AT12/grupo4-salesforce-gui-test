package org.fundacionjala.salesforce.ui.pages.tasks;

import org.fundacionjala.salesforce.config.APIEnvironment;
import java.util.HashMap;
import java.util.Map;

public final class TaskPageFactory {
    private static Map<String, TaskPage> contactDetailsMap = new HashMap<>();

    /**
     * Constructor.
     */
    private TaskPageFactory() {
    }

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
