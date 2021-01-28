package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.LightningCreateEventPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightningCalendarPage extends CalendarPage {

    @FindBy(className = "new-event-button")
    private WebElement btnNewEvent;

//    @FindBy(css = "a[title='Delete']")
//    private WebElement deleteOption;
//
//    @FindBy(css = "button[title='Delete']")
//    private WebElement btnDeleteMessage;
//
//    @FindBy(xpath = "//table/tbody")
//    private WebElement table;
//
//    private static final String TD_XPATH = "*[%1$s]//*[text()='%2$s']";
//    private static final String INI = "//tbody/tr[";
//    private static final String LAST = "]";
//    private static final String LINK_CONTACT = "//tbody//a[contains(@data-aura-class, 'Output')][@data-recordid='%s']";
//    private static final By HEADERS_BY = By.cssSelector("table[data-aura-class='uiVirtualDataTable'] thead tr th");

    /**
     * Constructor.
     */
    public LightningCalendarPage() {

    }

    /**
     * Opens CreateEventPopup
     */
    public CreateEventPopup openCreateEventPop() {
        WebDriverHelper.clickElement(btnNewEvent);
        return new LightningCreateEventPopup();
    }

//    /**
//     * Sets the search textBox.
//     * @param contact
//     */
//    private void setSearch(final String contact) {
//        WebDriverHelper.waitUntil(search);
//        WebDriverHelper.setElement(search, contact);
//    }
//
//    /**
//     * Searches contact by the contact search.
//     * @param contact
//     */
//    public void searchContact(final String contact) {
//        setSearch(contact);
//        search.sendKeys(Keys.ENTER);
//    }
//
//    /**
//     * Finds idContact in table.
//     * @param idContact
//     * @return
//     */
//    @Override
//    public WebElement findContactInTable(final String idContact) {
//        WebElement element = WebDriverManager.getInstance().getWebDriver()
//                .findElement(By.xpath(String.format(LINK_CONTACT, idContact)));
//        return element;
//    }
//
//    /**
//     * Deletes Contact.
//     * @param contact
//     */
//    @Override
//    public void deleteContact(final String contact) {
//        WebDriverHelper.waitUntil(deleteOption);
//        WebDriverHelper.clickElement(deleteOption);
//        WebDriverHelper.clickElement(btnDeleteMessage);
//    }
//
//
//    /**
//     * Gets ContactDetailsAbstractPage.
//     * @return ContactDetailsAbstractPage
//     */
//    @Override
//    public ContactDetailsPage navigateToContactsDetailsPage(final String idContact) {
//        WebElement element = findContactInTable(idContact);
//        WebDriverHelper.waitUntil(element);
//        WebDriverHelper.clickElement(element);
//        return new LightningContactDetailPage();
//    }
//
//    /**
//     * Creates Locator.
//     * @param contactInfo
//     * @return rowXpathLocator
//     */
//    @Override
//    public String createLocator(final HashMap<String, String> contactInfo) {
//        contactInfo.put("Name", contactInfo.get("Firstname") + " " + contactInfo.get("Lastname"));
//        Map<String, String> map = compareMap(contactInfo);
//        String rowXpathLocator = map.entrySet().stream().map(entry ->
//            String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
//        .collect(Collectors.joining(" and ", INI, LAST));
//        System.out.println(rowXpathLocator);
//        return rowXpathLocator;
//    }
//
//    /**
//     * Gets header position.
//     * @param key
//     * @return HeaderPosition
//     */
//    private String getHeaderPosition(final String key) {
//        ArrayList<String> headerText = new ArrayList<>();
//        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
//            headerText.add(header.getAttribute("aria-label"));
//        }
//        return String.valueOf(headerText.indexOf(key) + 1);
//    }
//
//    /**
//     * Compare Maps.
//     * @param contactInfo
//     * @return map
//     */
//    private Map<String, String> compareMap(final HashMap<String, String> contactInfo) {
//        Map<String, String> map = new HashMap<>();
//        System.out.println(getDriver().findElements(HEADERS_BY));
//        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
//            if (contactInfo.containsKey(header.getAttribute("aria-label"))) {
//                map.put(header.getAttribute("aria-label"), contactInfo.get(header.getAttribute("aria-label")));
//            }
//        }
//        return map;
//    }
}
