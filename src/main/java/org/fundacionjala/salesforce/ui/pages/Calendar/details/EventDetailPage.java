package org.fundacionjala.salesforce.ui.pages.Calendar.details;

import org.fundacionjala.salesforce.ui.pages.BasePage;

public abstract class EventDetailPage extends BasePage {

    /**
     * Verify if data is displayed
     * @param key
     * @param value
     * @return boolean
     */
    public abstract boolean isDataDisplayed(String key, String value);
}
