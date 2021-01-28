package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.Calendar.CalendarPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.CalendarPageFactory;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;

import java.util.HashMap;
import java.util.Map;

public class EventStepdefs {
    private CalendarPage calendarPage = CalendarPageFactory.getContactPage();
    private final Context context;

    public EventStepdefs(final Context context) {
        this.context = context;
    }

    @When("^I create the event with the following information$")
    public void createEvent(final Map<String, String> information) {
        //context.getEvent().processInformation(information);
        //CreateEventPopup createEventPopUp = calendarPage.openCreateEventPop();
        //createEventPopUp.createEvent(information);
    }

    @Then("{string} message should be displayed in Event Section")
    public void messageShouldBeDisplayedInEventSection(String arg0) {
    }

    @And("The event information should be displayed in Event Details section")
    public void theEventInformationShouldBeDisplayedInEventDetailsSection() {
    }

    @And("The event information should be displayed in Calendar section table")
    public void theEventInformationShouldBeDisplayedInCalendarSectionTable() {
    }

    @And("I Select the contact related to event")
    public void iSelectTheContactRelatedToEvent() {
    }

    @Then("The event information should be displayed in Contact Details page Activity section")
    public void theEventInformationShouldBeDisplayedInContactDetailsPageActivitySection() {
    }

    @And("I Select the campaign related to event")
    public void iSelectTheCampaignRelatedToEvent() {
    }

    @Then("The event information should be displayed in Campaign Details page Activity section")
    public void theEventInformationShouldBeDisplayedInCampaignDetailsPageActivitySection() {
    }
}
