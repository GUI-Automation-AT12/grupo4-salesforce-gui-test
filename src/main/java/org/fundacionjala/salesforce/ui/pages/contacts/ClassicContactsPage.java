package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ClassicContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassicContactsPage extends ContactsPage {

    @FindBy(css = "table.list tbody")
    private WebElement table;

    private String xpathLink  = "//tr//a[contains(text(),'%s')]";

    private ClassicContactDetailsPage contactDetailsPage;

    private static final String TD_XPATH = "//*[%1$s][text()='%2$s']";
    private static final String INI = "//table[@class='list']/tbody/tr[contains(@class,'dataRow')][";
    private static final String LAST = "]";
    private static final String LINK_CONTACT = "table.list tbody .dataCell a[href*='%s']";
    private static final By HEADERS_BY = By.xpath("//table[@class='list']/tbody/tr[@class='headerRow']/th");
    /**
     * Constructor.
     */
    public ClassicContactsPage() {

    }

    /**
     * Searches a contact by id contact.
     * @param idContact
     * @return
     */
    private ClassicContactDetailsPage getContactDetailsPage (final String idContact){
        WebElement element = findContactInTable(idContact);
        WebDriverHelper.waitUntil(element);
        WebDriverHelper.clickElement(element);
        return new ClassicContactDetailsPage();
    }

    /**
     * @param contact
     */
    @Override
    public void searchContact(String contact) {

    }

    /**
     * Deletes a contact.
     * @param idContact
     * @return
     */
    @Override
    public WebElement findContactInTable(final String idContact) {
        String id = idContact.substring(0, idContact.length()-3);
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.cssSelector(String.format(LINK_CONTACT,id)));
        return element;
    }

    /**
     * Deletes Contact.
     * @param contact
     */
    @Override
    public void deleteContact(final String contact) {
        contactDetailsPage.clickBtnDelete();
    }

    /**
     * Gets ContactDetailsAbstractPage.
     * @return ContactDetailsAbstractPage
     */
    @Override
    public ContactDetailsPage navigateToContactsDetailsPage(final String idContact) {
        WebElement element = findContactInTable(idContact);
        WebDriverHelper.waitUntil(element);
        WebDriverHelper.clickElement(element);
        return new ClassicContactDetailsPage();
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        contactInfo.put("Name", contactInfo.get("Lastname") + ", " + contactInfo.get("Firstname"));
        System.out.println(contactInfo);
        Map<String, String> map = compareMap(contactInfo);
        String rowXpathLocator = map.entrySet().stream().map(entry ->
            String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
            .collect(Collectors.joining(" and ", INI, LAST));
        System.out.println(rowXpathLocator);
        return rowXpathLocator;
    }

    /**
     * Gets header position.
     * @param key
     * @return
     */
    private String getHeaderPosition(final String key) {
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : driver.findElements(HEADERS_BY)) {
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
        System.out.println(driver.findElement(HEADERS_BY));
        for (WebElement header : driver.findElements(HEADERS_BY)) {
            if (contactInfo.containsKey(header.getText())) {
                map.put(header.getText(), contactInfo.get(header.getText()));
            }
        }
        return map;
    }
}
