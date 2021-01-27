package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;

public abstract class TaskDetailsPage {
    /**
     *
     * @param task
     */
    public abstract void validateTaskInformation(Task task);
}
