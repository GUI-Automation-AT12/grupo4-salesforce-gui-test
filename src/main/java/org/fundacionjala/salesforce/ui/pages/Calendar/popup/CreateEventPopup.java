package org.fundacionjala.salesforce.ui.pages.Calendar.popup;

import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public abstract class CreateEventPopup extends BasePage {

    /**
     *
     * @param information
     */
    public abstract void createEvent(Map<String, String> information) throws InterruptedException;

}
