package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.opportunities.OpportunityFactory;
import org.fundacionjala.salesforce.ui.pages.opportunities.OpportunityPage;
import org.fundacionjala.salesforce.ui.pages.opportunities.details.OpportunityDetailsFactory;
import org.fundacionjala.salesforce.ui.pages.opportunities.details.OpportunityDetailsPage;
import org.fundacionjala.salesforce.utils.setup.MainSetup;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class OpportunityStepdefs {

    private Context context;
    public OpportunityStepdefs(Context context) {
        this.context =  context;
    }

    @Given("I created a valid opportunity")
    public void iCreatedAValidOpportunity() {
        MainSetup setupHelper = new MainSetup();
        setupHelper.setupOpportunities();
    }

    @And("I create an Opportunity with the following data")
    public void iCreateAnOpportunityWithTheFollowingData(Map<String, String> opportunityInformation) {
        OpportunityPage opportunityPage = OpportunityFactory.getOpportunityPage();
        opportunityPage.addOpportunity();
        opportunityPage.getOpportunityForm().setData(opportunityInformation, context.getAccount().getName());
        opportunityPage.getOpportunityForm().saveOpportunity();
        context.setOpportunity(opportunityPage.getOpportunityForm().getOpportunity());
    }

    @Then("the opportunity's name should be displayed on Opportunity details page")
    public void theOpportunitySNameShouldBeDisplayedOnOpportunityDetailsPage() {
        OpportunityDetailsPage opportunityDetailsPage = OpportunityDetailsFactory.getTaskDetailsPage();
        Assert.assertTrue(opportunityDetailsPage.validateTitle(context.getOpportunity()));
    }

    @And("the opportunity's information should match")
    public void theOpportunitySInformationShouldMatch() {
        OpportunityDetailsPage opportunityDetailsPage = OpportunityDetailsFactory.getTaskDetailsPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(opportunityDetailsPage.getOpportunityName(), context.getOpportunity().getOpportunityName());
        softAssert.assertEquals(opportunityDetailsPage.getAccount(), context.getOpportunity().getAccountName());
        softAssert.assertEquals(opportunityDetailsPage.getCloseDate(), context.getOpportunity().getCloseDate());
        softAssert.assertEquals(opportunityDetailsPage.getStage(), context.getOpportunity().getStage());
        softAssert.assertAll();
    }

    @When("I close the driver")
    public void iCloseTheDriver() {
    }
}
