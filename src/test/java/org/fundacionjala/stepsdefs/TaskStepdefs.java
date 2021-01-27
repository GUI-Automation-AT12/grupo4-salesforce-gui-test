package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPageFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.TaskPage;
import org.fundacionjala.salesforce.ui.pages.tasks.TaskPageFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
        ContactDetailsPage contactDetailsPage = ContactDetailsPageFactory.getContactDetailsPage();
        contactDetailsPage.selectCreatedTask(context.getTask());
    }

    @And("The task's information should match")
    public void theTaskSInformationShouldMatch() {
        TaskDetailsPage taskDetailsPage = TaskDetailsFactory.getTaskDetailsPage();
        taskDetailsPage.validateTaskInformation(context.getTask());
        SoftAssert softAssertion= new SoftAssert();
        Boolean flag = taskDetailsPage.getTextDueDate();
        softAssertion.assertTrue(taskDetailsPage.getTextDueDate());
        softAssertion.assertTrue(taskDetailsPage.getTextRelatedTo());
        softAssertion.assertTrue(taskDetailsPage.getTextStatus());
        softAssertion.assertTrue(taskDetailsPage.getTextSubject());
        softAssertion.assertAll();
    }
}
