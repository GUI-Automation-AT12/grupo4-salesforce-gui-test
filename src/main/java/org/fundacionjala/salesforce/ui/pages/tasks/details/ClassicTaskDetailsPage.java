package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;

public class ClassicTaskDetailsPage extends TaskDetailsPage {


    public ClassicTaskDetailsPage() {
        task = new Task();
    }

    @Override
    public Boolean validateTaskInformation(Task task) {
        return false;
    }

    @Override
    public boolean getTextSubject() {
        return false;
    }

    @Override
    public boolean getTextDueDate() {
        return false;
    }

    @Override
    public boolean getTextStatus() {
        return false;
    }

    @Override
    public boolean getTextRelatedTo() {
        return false;
    }
}
