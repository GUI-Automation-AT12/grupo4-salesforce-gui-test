package org.fundacionjala.salesforce.ui.pages.recycle;

import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public abstract class RecycleBinPage extends BasePage {

    /**
     * Sets search.
     * @param contact
     */
    public abstract void setSearch(String contact);

    /**
     * Searches contact.
     * @param contact
     */
    public abstract void searchContact(String contact);

    /**
     * Finds contact in table.
     * @param contact
     * @return element
     */
    public abstract WebElement findContactInTable(String contact);

    /**
     * Gets text from table.
     * @param contact
     * @return text.
     */
    public abstract String getTextFromTable(String contact);

    /**
     * Gets text from table.
     * @return text.
     * @param record
     */
    public abstract boolean findRecord(Map<String, String> record);

    /**
     *Waits until page is loaded.
     */
    public abstract void waitUntilPageIsLoaded();

    /**
     * Verify if Information is displayed in the table.
     * @param contactInfo
     * @return if element
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
}
