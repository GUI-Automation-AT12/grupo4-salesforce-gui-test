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
    public abstract void setSearch(final String contact);

    /**
     * Searches contact.
     * @param contact
     */
    public abstract void searchContact (final String contact);

    /**
     * Finds contact in table.
     * @param contact
     * @return element
     */
    public abstract WebElement findContactInTable(final String contact);

    /**
     * Gets text from table.
     * @param contact
     * @return text.
     */
    public abstract String getTextFromTable(final String contact);

    /**
     * Gets text from table.
     * @return text.
     * @param record
     */
    public abstract boolean findRecord(final Map<String, String> record);

    /**
     *Waits until page is loaded.
     */
    public abstract void waitUntilPageIsLoaded();

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
}
