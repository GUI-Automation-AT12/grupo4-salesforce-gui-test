package org.fundacionjala.salesforce.ui.pages.contacts.details;

import org.fundacionjala.salesforce.entities.Task;
import org.fundacionjala.salesforce.ui.pages.BasePage;

import java.util.Map;

public abstract class ContactDetailsPage extends BasePage {

    protected Task task;
    public abstract void createTask(Map<String, String> taskInformation);
    public abstract Task getTask();
}
