package org.fundacionjala.salesforce.ui.pages.recycle;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RecycleBinLightningPage extends RecycleBinAbstractPage {

    private String xpathDeletedItem = "//table//tbody/tr//span[contains(text(),'%s')]";
    private String spanRecord = "//tbody//th//span[@title= '%s']";

    @FindBy(xpath = "//table/tbody")
    private WebElement table;

    private static final String TD_XPATH = "*[%1$s]//*[text()='%2$s']";
    private static final String INI = "//tbody/tr[";
    private static final String LAST = "]";
    private static final String LINK_CONTACT = "//tbody//a[contains(@data-aura-class, 'Output')][@data-recordid='%s']";
    private static final By HEADERS_BY = By.cssSelector("table[data-aura-class='uiVirtualDataTable'] thead tr th");


    /**
     * Sets search.
     *
     * @param contact
     */
    @Override
    public void setSearch(String contact) {

    }

    /**
     * Searches contact.
     *
     * @param contact
     */
    @Override
    public void searchContact(String contact) {

    }

    /**
     * Finds contact in table.
     *
     * @param contact
     * @return element
     */
    @Override
    public WebElement findContactInTable(String contact) {
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(String.format(xpathDeletedItem, contact)));
        return element;
    }

    /**
     * Gets text from table.
     *
     * @param contact
     * @return text.
     */
    @Override
    public String getTextFromTable(String contact) {
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(String.format(xpathDeletedItem,contact)));
        return WebDriverHelper.getTextElement(element);
    }

    /**
     * Verifies the contact.
     * @return
     * @param record
     */
    @Override
    public boolean findRecord(final Map<String, String> record) {
        String recordName = record.get("Firstname") + " " + record.get("Lastname");
        WebElement element = getWebDriver().findElement(By.xpath(String.format(spanRecord, recordName)));
        return element.isDisplayed();
    }

    /**
     * Waits Until Page is loaded.
     */
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntil(table);
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        contactInfo.put("Record Name", contactInfo.get("Firstname") + " " + contactInfo.get("Lastname"));
        Map<String, String> map = compareMap(contactInfo);
        String rowXpathLocator = map.entrySet().stream().map(entry ->
                String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
                .collect(Collectors.joining(" and ", INI, LAST));
        return rowXpathLocator;
    }

    /**
     * Gets header position.
     * @param key
     * @return
     */
    private String getHeaderPosition(String key) {
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : getWebDriver().findElements(HEADERS_BY)) {
            headerText.add(header.getAttribute("aria-label"));
        }
        return String.valueOf(headerText.indexOf(key) + 1);
    }

    /**
     * Compare Maps.
     * @return map
     */
    private Map<String, String> compareMap(final HashMap<String, String> contactInfo) {
        Map<String, String> map = new HashMap<>();
        for (WebElement header : getWebDriver().findElements(HEADERS_BY)) {
            if (contactInfo.containsKey(header.getAttribute("aria-label"))) {
                map.put(header.getAttribute("aria-label"), contactInfo.get(header.getAttribute("aria-label")));
            }
        }
        return map;
    }
}
