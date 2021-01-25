package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.details.ContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.details.ContactDetailsPageFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.TaskPage;
import org.fundacionjala.salesforce.ui.pages.tasks.TaskPageFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;

import java.util.Map;

public class TaskStepdefs {
    
    private Context context;

    public TaskStepdefs(final Context context) {
        this.context = context;
    }

    @And("I create a task with the following data")
    public void iCreateATaskWithTheFollowingData(Map<String, String> taskInformation) {
        ContactDetailsPage contactDetails = ContactDetailsPageFactory.getContactDetailsPage();
        contactDetails.createTask(taskInformation);
        context.setTask(contactDetails.getTask());
    }

    @Then("The task should be displayed on Tasks page")
    public void theTaskShouldBeDisplayedOnTasksPage() throws Exception {
        TransporterPage.navigateToPage("Task");
        TaskPage tsk = TaskPageFactory.getContactDetailsPage();
        tsk.verifyTask(context.getTask());
    }

    @And("The task's information should match")
    public void theTaskSInformationShouldMatch() {
        TaskDetailsPage taskDetailsPage = TaskDetailsFactory.getTaskDetailsPage();
        taskDetailsPage.validateTaskInformation(context.getTask());
    }
}
