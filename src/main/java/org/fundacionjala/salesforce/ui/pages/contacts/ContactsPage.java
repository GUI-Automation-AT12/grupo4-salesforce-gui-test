package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * [RH] Abstract ContactPage.
 */
public abstract class ContactsPage extends BasePage {

    /**
     *
     * @param contact
     */
    public abstract void searchContact(String contact);

    /**
     *
     * @param idContact
     * @return element
     */
    public abstract WebElement findContactInTable(String idContact);

    /**
     *
     * @param contact
     */
    public abstract void deleteContact(String contact);

    /**
     * Verify if Information is displayed in the table.
     * @param contactInfo
     * @return isDisplayed
     */
    public boolean isContactInformationDisplayed(final HashMap<String, String> contactInfo) {
        return getDriver().findElement(By.xpath(createLocator(contactInfo))).isDisplayed();
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return locator
     */
    public abstract String createLocator(HashMap<String, String> contactInfo);

    /**
     * Gets ContactDetailsAbstractPage.
     * @param idContact
     * @return ContactDetailsAbstractPage
     */
    public abstract ContactDetailsPage navigateToContactsDetailsPage(String idContact);

    /**
     *
     * @param id
     * @return name
     */
    public abstract String getContactName(String id);

    /**
     *
     * @param contact
     */
    public abstract void setSearch(String contact);

    /**
     *
     * @param id
     */
    public abstract void selectContact(String id);
}
