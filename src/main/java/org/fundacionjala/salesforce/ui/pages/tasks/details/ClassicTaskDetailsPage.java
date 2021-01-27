package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;

public class ClassicTaskDetailsPage extends TaskDetailsPage {


    public ClassicTaskDetailsPage() {
        task = new Task();
    }
    
    @Override
    public void validateTaskInformation(final Task task) {

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
