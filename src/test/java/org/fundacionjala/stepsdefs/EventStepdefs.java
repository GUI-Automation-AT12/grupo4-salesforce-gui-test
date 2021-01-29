package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.ui.pages.Calendar.CalendarPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.CalendarPageFactory;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.EventDetailPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactPageFactory;
import org.fundacionjala.salesforce.ui.pages.contacts.ContactsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class EventStepdefs {
    private CalendarPage calendarPage = CalendarPageFactory.getContactPage();
    private ContactsPage contactsPage;
    private EventDetailPage eventDetailPage;
    private ContactDetailsPage contactDetailsPage;
    private final Context context;

    public EventStepdefs(final Context context) {
        this.context = context;
    }

    @When("I create the event with the following information")
    public void iCreateTheEventWithTheFollowingInformation(final Map<String, String> information) throws InterruptedException {
        context.getEvent().processInformation(information);
        CreateEventPopup createEventPopUp = calendarPage.openCreateEventPop();
        createEventPopUp.createEvent(information);
        TransporterPage.refreshPage();
    }

    @Then("the event information should be displayed in Calendar section table")
    public void theEventInformationShouldBeDisplayedInCalendarSectionTable() {
        Assert.assertTrue(calendarPage.isDataDisplayed(context.getEvent()));

    }

    @Then("the event information should be displayed in Event Details page")
    public void theEventInformationShouldBeDisplayedInEventDetailsSection() {
        eventDetailPage = calendarPage.selectEvent(context.getEvent());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(eventDetailPage.isDataDisplayed("Subject",context.getEvent().getSubject()));
        softAssert.assertTrue(eventDetailPage.isDataDisplayed("Location",context.getEvent().getLocation()));
        softAssert.assertTrue(eventDetailPage.isDataDisplayed("Name",context.getEvent().getName()));
        softAssert.assertTrue(eventDetailPage.isDataDisplayed("Related To",context.getEvent().getRelatedTo()));
        softAssert.assertAll();
    }

    @When("I Select the contact related to event")
    public void iSelectTheContactRelatedToEvent() {
        contactsPage = ContactPageFactory.getContactPage();
        contactsPage.searchContact(context.getContact().getFirstname());
        contactDetailsPage = contactsPage.navigateToContactsDetailsPage(context.getContact().getIdContact());
    }

    @Then("The event information should be displayed in Contact Details page Activity section")
    public void theEventInformationShouldBeDisplayedInContactDetailsPageActivitySection() {
        HashMap<String, String> data = new HashMap<>();
        data.put("Subject", context.getEvent().getSubject());
        data.put("Related To" , context.getEvent().getRelatedTo());
        assertTrue(contactDetailsPage.isInformationDisplayed((data)));
    }
}
