package org.fundacionjala.salesforce.ui.pages.recycle;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassicRecycleBinPage extends RecycleBinPage {

    private String xpathDeletedItem = "//table//tbody/tr//span[contains(text(),'%s')]";
    private String spanRecord = "//tbody/tr[contains(@class,'dataRow')]//*[text()= '%s']";

    @FindBy(id = "recycleSearch")
    private WebElement search;

    @FindBy(className = "list")
    private WebElement table;

    private static final String TD_XPATH = "//*[%1$s][text()='%2$s']";
    private static final String INI = "//table[@class='list']/tbody/tr[contains(@class,'dataRow')][";
    private static final String LAST = "]";
    private static final String LINK_CONTACT = "table.list tbody .dataCell a[href*='%s']";
    private static final By HEADERS_BY = By.xpath("//table[@class='list']/tbody/tr[@class='headerRow']/th");

    /**
     *
     * @param contact
     */
    public void setSearch(final String contact) {
        WebDriverHelper.waitUntil(search);
        WebDriverHelper.setElement(search, contact);
    }

    /**
     *
     * @param contact
     */
    public void searchContact (final String contact){
        setSearch(contact);
        search.sendKeys(Keys.ENTER);
        WebDriverHelper.waitUntil(table);
    }

    /**
     *
     * @param contact
     * @return element
     */
    public WebElement findContactInTable(final String contact) {
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(String.format(xpathDeletedItem,contact)));
        return element;
    }

    /**
     *
     * @param contact
     * @return text.
     */
    public String getTextFromTable(final String contact) {
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(String.format(xpathDeletedItem,contact)));
        return WebDriverHelper.getTextElement(element);
    }

    /**
     * Gets text from table.
     *
     * @return text.
     * @param record
     */
    @Override
    public boolean findRecord(final Map<String, String> record) {
        String recordName = record.get("Firstname") + " " + record.get("Lastname");
        WebElement element = getWebDriver().findElement(By.xpath(String.format(spanRecord, recordName)));
        return element.isDisplayed();
    }

    /**
     * Waits unitl page is loaded.
     */
    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntil(search);
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        contactInfo.put("Name", contactInfo.get("Firstname") + " " + contactInfo.get("Lastname"));
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
    private String getHeaderPosition(final String key) {
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : getWebDriver().findElements(HEADERS_BY)) {
            headerText.add(header.getText());
        }
        return String.valueOf(headerText.indexOf(key) + 1);
    }

    /**
     * Compare Maps.
     * @return map
     */
    private Map<String, String> compareMap(final HashMap<String, String> contactInfo) {
        Map<String, String> map = new HashMap<>();
        System.out.println(getWebDriver().findElement(HEADERS_BY));
        for (WebElement header : getWebDriver().findElements(HEADERS_BY)) {
            if (contactInfo.containsKey(header.getText())) {
                map.put(header.getText(), contactInfo.get(header.getText()));
            }
        }
        return map;
    }
}
