package org.fundacionjala.salesforce.ui.pages.contacts.details;

import org.fundacionjala.salesforce.entities.Task;

import java.util.Map;

public class ClassicContactDetailsPage extends ContactDetailsPage {

    public ClassicContactDetailsPage() {
        task = new Task();
    }

    @Override
    public void createTask(Map<String, String> taskInformation) {

    }

    @Override
    public Task getTask() {
        return null;
    }

    public void selectCreatedTask(Task task) {

    }

}
