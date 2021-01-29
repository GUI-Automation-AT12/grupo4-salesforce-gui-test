package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ClassicContactDetailsPage;
import org.fundacionjala.salesforce.ui.pages.contacts.contactdetails.ContactDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassicContactsPage extends ContactsPage {

    private static final int NUMBER = 3;
    @FindBy(css = "table.list tbody")
    private WebElement table;

    @FindBy(id = "phSearchInput")
    private WebElement txtSearch;

    @FindBy(xpath = "//div/h2[@class='topName']")
    private WebElement nameTitle;

    private static final String TD_XPATH = "*[%1$s]//*[text()='%2$s']";
    private static final String TD_XPATH2 = "*[%1$s][text()='%2$s']";
    private static final String INI = "//table[@class='list']/tbody/tr[contains(@class,'dataRow')][";
    private static final String LAST = "]";
    private static final String LINK_CONTACT = "table.list tbody .dataCell a[href*='%s']";
    private static final By HEADERS_BY = By.xpath("//table[@class='list']/tbody/tr[@class='headerRow']/th");
    private static final String LINK = "//table/tbody//tr//td//th//a[text()=' %S']";
    private String xpathLink  = "//tr//a[contains(text(),'%s')]";
    private ClassicContactDetailsPage contactDetailsPage;
    private String linkContact = "//table/tbody//tr//td//th//a[text()=' %S']";
    private String nameContact;

    /**
     * Constructor.
     */
    public ClassicContactsPage() {

    }

    /**
     * Searches a contact by id contact.
     * @param idContact
     * @return ClassicContactDetailsPage
     */
    private ClassicContactDetailsPage getContactDetailsPage(final String idContact) {
        WebElement element = findContactInTable(idContact);
        WebDriverHelper.waitUntil(element);
        WebDriverHelper.clickElement(element);
        return new ClassicContactDetailsPage();
    }

    /**
     *
     * @param contact
     */
    @Override
    public void setSearch(final String contact) {
        WebDriverHelper.waitUntil(txtSearch);
        WebDriverHelper.setElement(txtSearch, contact);
        nameContact = contact;
    }

    /**
     * @param contact
     */
    @Override
    public void searchContact(final String contact) {
        setSearch(contact);
        txtSearch.sendKeys(Keys.ENTER);
    }

    /**
     * Finds a contact.
     * @param idContact
     * @return element
     */
    @Override
    public WebElement findContactInTable(final String idContact) {
        String id = idContact.substring(0, idContact.length() - NUMBER);
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.cssSelector(String.format(LINK_CONTACT, id)));
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
     *
     * @param contact
     */
    public void findContact(final String contact) {
        String text = changeInitials(String.format(linkContact, contact).toLowerCase());
        WebElement element = getDriver().findElement(By.xpath(changeInitials(text.replaceAll("=' ", "='"))));
        WebDriverHelper.waitUntil(element);
        WebDriverHelper.clickElement(element);
    }

    /**
     * Creates Locator.
     * @param contactInfo
     * @return rowXpathLocator
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        contactInfo.put("Name", contactInfo.get("Firstname") + " " + contactInfo.get("Lastname"));
        Map<String, String> map = compareMap(contactInfo);
        String rowXpathLocator = INI;
        for(Map.Entry entry : map.entrySet()) {
            if(!INI.equals(rowXpathLocator)) {
                rowXpathLocator += " and ";
            }
            if (entry.getKey().toString().equals("Account Site") || entry.getKey().toString().equals("Phone") ) {
                rowXpathLocator += String.format(TD_XPATH2, getHeaderPosition(entry.getKey().toString()),entry.getValue());
            } else {
                rowXpathLocator += String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()),entry.getValue());
            }
        }
        return rowXpathLocator + LAST;
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

    /**
     *
     * @param id
     */
    public void selectContact(final String id) {
        findContact(nameContact);
    }

    /**
     *
     * @param id
     * @return name
     */
    @Override
    public String getContactName(final String id) {
        return WebDriverHelper.getTextElement(nameTitle);
    }

    /**
     *
     * @param text
     * @return text
     */
    public String changeInitials(final String text) {
        String[] split = text.split("");
        for (int i = 0; i < split.length; i++) {
            if (i == 0 || split[i - 1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            }
        }
        return String.join("", split);
    }
}
