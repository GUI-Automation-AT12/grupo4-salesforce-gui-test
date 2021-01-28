package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPageFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsFactory;
import org.fundacionjala.salesforce.ui.pages.tasks.details.TaskDetailsPage;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class TaskStepdefs {
    
    private Context context;
    private ContactsPage contactsPage;
    public TaskStepdefs(final Context context) {
        this.context = context;
        contactsPage = ContactPageFactory.getContactPage();
    }

    @And("I create a task with the following data")
    public void iCreateATaskWithTheFollowingData(Map<String, String> taskInformation) {
        contactsPage.selectContact(context.getValueData("Id"));
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
        SoftAssert softAssertion= new SoftAssert();
        taskDetailsPage.validateTaskInformation(context.getTask());
        softAssertion.assertTrue(taskDetailsPage.validateTaskInformation(context.getTask()));
        softAssertion.assertTrue(taskDetailsPage.getTextDueDate());
        softAssertion.assertTrue(taskDetailsPage.getTextRelatedTo());
        softAssertion.assertTrue(taskDetailsPage.getTextStatus());
        softAssertion.assertTrue(taskDetailsPage.getTextSubject());
        softAssertion.assertAll();
    }
}
