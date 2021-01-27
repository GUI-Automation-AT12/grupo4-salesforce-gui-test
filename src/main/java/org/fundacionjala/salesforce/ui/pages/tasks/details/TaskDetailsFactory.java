package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.config.APIEnvironment;
import java.util.HashMap;
import java.util.Map;

public final class TaskDetailsFactory {

    private static Map<String, TaskDetailsPage> taskDetailsMap = new HashMap<>();

    /**
     * Constructor.
     */
    private TaskDetailsFactory() {
    }

    static {
        taskDetailsMap.put("lightning", new LightningTaskDetailsPage());
        taskDetailsMap.put("classic", new ClassicTaskDetailsPage());
    }

    /**
     * Gets a Abstract TaskDetailsPage class.
     * @return a TaskDetailsPage.
     */
    public static TaskDetailsPage getTaskDetailsPage() {
        return taskDetailsMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
