package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;
import org.fundacionjala.salesforce.ui.pages.BasePage;

public abstract class TaskDetailsPage extends BasePage {

    protected Task task;
    public abstract Boolean validateTaskInformation(Task task);
    public abstract boolean getTextSubject();
    public abstract boolean getTextDueDate();
    public abstract boolean getTextStatus();
    public abstract boolean getTextRelatedTo();
}
