package org.fundacionjala.salesforce.ui.pages.contactDetailsPage;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.BasePage;

public abstract class ContactDetailsAbstractPage extends BasePage {

    /**
     * Clicks in button delete.
     */
    public abstract void clickBtnDelete();

    /**
     * Click in button delete.
     */
    public abstract void clickBtnConfirmDelete();

    /**
     * Deletes the contact.
     */
    public abstract void deleteContact();

    /**
     * Verifies if element is loaded.
     */
    public abstract void waitUntilPageIsLoaded();
}
