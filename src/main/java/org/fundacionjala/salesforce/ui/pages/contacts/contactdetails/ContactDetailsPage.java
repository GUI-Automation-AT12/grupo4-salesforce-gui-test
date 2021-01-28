package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.salesforce.entities.Task;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import java.util.Map;

/**
 * [RH] ContactDetailsPage.
 */
public abstract class ContactDetailsPage extends BasePage {

    protected Task task;

    /**
     *
     * @param taskInformation
     */
    public abstract void createTask(Map<String, String> taskInformation);

    /**
     *
     * @return task
     */
    public abstract Task getTask();
    /**
     * Clicks in button delete.
     */
    public abstract void clickBtnDelete();

    /**
     * Click in button delete.
     */
    public abstract void clickBtnConfirmDelete();

    /**
     * Deletes the contact.
     */
    public abstract void deleteContact();

    /**
     * Verifies if element is loaded.
     */
    public abstract void waitUntilPageIsLoaded();

    /**
     *
     * @param task
     */
    public abstract void selectCreatedTask(Task task);
}
