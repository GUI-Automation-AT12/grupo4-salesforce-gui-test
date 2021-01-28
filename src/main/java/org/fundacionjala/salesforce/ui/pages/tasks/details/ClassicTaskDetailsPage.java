package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;

/**
 * [RH] ClassicTaskDetailsPage.
 */
public class ClassicTaskDetailsPage extends TaskDetailsPage {

    /**
     * Constructor.
     */
    public ClassicTaskDetailsPage() {
        task = new Task();
    }

    /**
     * Validates task information.
     * @param task
     * @return
     */
    @Override
    public Boolean validateTaskInformation(final Task task) {
        return false;
    }

    /**
     * [RH].
     * @return Subject text.
     */
    @Override
    public boolean getTextSubject() {
        return false;
    }

    /**
     * [RH].
     *
     * @return Due date text.
     */
    @Override
    public boolean getTextDueDate() {
        return false;
    }

    /**
     * [RH].
     *
     * @return Status text.
     */
    @Override
    public boolean getTextStatus() {
        return false;
    }

    /**
     * [RH].
     *
     * @return Related with text.
     */
    @Override
    public boolean getTextRelatedTo() {
        return false;
    }
}
