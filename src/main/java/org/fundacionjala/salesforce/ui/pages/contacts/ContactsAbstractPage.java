package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.contactDetailsPage.ContactDetailsAbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public abstract class ContactsAbstractPage extends BasePage {

    /**
     *
     * @param contact
     */
    public abstract void searchContact(final String contact);

    /**
     *
     * @param idContact
     * @return
     */
    public abstract WebElement findContactInTable(final String idContact);

    /**
     *
     * @param contact
     */
    public abstract void deleteContact(final String contact);

    /**
     * Verify if Information is displayed in the table.
     * @param contactInfo
     */
    public boolean isContactInformationDisplayed(final HashMap<String, String> contactInfo) {
        return getWebDriver().findElement(By.xpath(createLocator(contactInfo))).isDisplayed();
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return
     */
    public abstract String createLocator(final HashMap<String, String> contactInfo);

    /**
     * Gets ContactDetailsAbstractPage.
     * @return ContactDetailsAbstractPage
     */
    public abstract ContactDetailsAbstractPage navigateToContactsDetailsPage(final String idContact);
}
