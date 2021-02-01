package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [RH] ClassicContactDetailsPage.
 */
public class ClassicContactDetailsPage extends ContactDetailsPage {

    @FindBy(css = "input[name='del']")
    private WebElement btnDelete;


    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

    private static final String TD_XPATH_HISTORY = "//*[%1$s]/a[text()='%2$s'] ";
    private static final String INI_HISTORY = "//h3[text()='Activity History']/ancestor::div[@class='pbHeader']/following-sibling::div[@class='pbBody']//tr[contains(@class, 'dataRow')][";
    private static final String END = "]";
    private static final By HEADERS_BY = By.xpath("//h3[text()='Activity History']/ancestor::div[@class='pbHeader']/following-sibling::div[@class='pbBody']//tr[@class='headerRow']/th");


    /**
     * @param taskInformation
     */
    @Override
    public void createTask(final Map<String, String> taskInformation) {

    }

    /**
     * @return task
     */
    @Override
    public Task getTask() {
        return null;
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void clickBtnDelete() {
        WebDriverHelper.clickElement(btnDelete);
    }

    /**
     * Click in button delete.
     */
    @Override
    public void clickBtnConfirmDelete() {
        getDriver().switchTo().alert().accept();
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void deleteContact() {
        clickBtnDelete();
        clickBtnConfirmDelete();
    }

    /**
     * Waits until page is loaded.
     */
    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntil(btnDelete);
    }

    @Override
    public void selectCreatedTask(final Task task) {

    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        Map<String, String> map = compareMap(contactInfo);
        String rowXpathLocator = map.entrySet().stream().map(entry ->
                String.format(TD_XPATH_HISTORY, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
                .collect(Collectors.joining(" and ", INI_HISTORY, END));
        return rowXpathLocator;
    }

    /**
     * Gets header position.
     * @param key
     * @return HeaderPosition
     */
    private String getHeaderPosition(final String key) {
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
            headerText.add(header.getText());
        }
        return String.valueOf(headerText.indexOf(key) + 1);
    }

    /**
     * Compare Maps.
     * @param contactInfo
     * @return map
     */
    private Map<String, String> compareMap(final HashMap<String, String> contactInfo) {
        Map<String, String> map = new HashMap<>();
        System.out.println(getDriver().findElement(HEADERS_BY));
        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
            if (contactInfo.containsKey(header.getText())) {
                map.put(header.getText(), contactInfo.get(header.getText()));
            }
        }
        return map;
    }
}
