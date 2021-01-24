package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.fundacionjala.salesforce.context.Context;

import java.util.Map;

public class TaskStepdefs {
    
    private Context context;

    public TaskStepdefs(final Context context) {
        this.context = context;
    }

    @And("I create a task with the following data")
    public void iCreateATaskWithTheFollowingData(Map<String, String> taskInformation) {

    }

    @Then("The task should be displayed on Tasks page")
    public void theTaskShouldBeDisplayedOnTasksPage() {
    }

    @And("The task's information should match")
    public void theTaskSInformationShouldMatch() {
    }
}
