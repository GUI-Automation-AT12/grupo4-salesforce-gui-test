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
    public abstract void createEvent(Map<String, String> information);

//    /**
//     *
//     * @param contact
//     */
//    public abstract void searchContact(String contact);
//
//    /**
//     *
//     * @param idContact
//     * @return element
//     */
//    public abstract WebElement findContactInTable(String idContact);
//
//    /**
//     *
//     * @param contact
//     */
//    public abstract void deleteContact(String contact);
//
//    /**
//     * Verify if Information is displayed in the table.
//     * @param contactInfo
//     * @return isDisplayed
//     */
//    public boolean isContactInformationDisplayed(final HashMap<String, String> contactInfo) {
//        return getDriver().findElement(By.xpath(createLocator(contactInfo))).isDisplayed();
//    }
//
//    /**
//     * Creates Locator.
//     * @param contactInfo
//     * @return locator
//     */
//    public abstract String createLocator(HashMap<String, String> contactInfo);
//
//    /**
//     * Gets ContactDetailsAbstractPage.
//     * @param idContact
//     * @return ContactDetailsAbstractPage
//     */
//    public abstract ContactDetailsPage navigateToContactsDetailsPage(String idContact);

}
