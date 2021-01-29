package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.salesforce.entities.Event;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.EventDetailPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;

public abstract class CalendarPage extends BasePage {
    /**
     *
     * @return Page
     */
    public abstract CreateEventPopup openCreateEventPop();

    /**
     * @param event
     * @return page
     */
     public abstract EventDetailPage selectEvent(Event event);

    /**
     *
     * @param event
     * @return boolean
     */
    public abstract boolean isDataDisplayed(Event event);
}
