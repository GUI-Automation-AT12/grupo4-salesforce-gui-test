package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public abstract class ContactsPage extends BasePage {

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
        return driver.findElement(By.xpath(createLocator(contactInfo))).isDisplayed();
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
    public abstract ContactDetailsPage navigateToContactsDetailsPage(final String idContact);

}
