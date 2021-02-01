package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;
import org.fundacionjala.salesforce.ui.pages.BasePage;

/**
 * [RH].
 */
public abstract class TaskDetailsPage extends BasePage {

    protected Task task;

    /**
     * [RH].
     * @param task
     * @return validated information.
     */
    public abstract Boolean validateTaskInformation(Task task);

    /**
     *[RH].
     * @return Subject text.
     */
    public abstract boolean getTextSubject();

    /**
     *[RH].
     * @return Due date text.
     */
    public abstract boolean getTextDueDate();

    /**
     *[RH].
     * @return Status text.
     */
    public abstract boolean getTextStatus();

    /**
     *[RH].
     * @return Related with text.
     */
    public abstract boolean getTextRelatedTo();
}
