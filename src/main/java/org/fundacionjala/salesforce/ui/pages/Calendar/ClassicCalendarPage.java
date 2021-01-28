package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.ClassicCreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.LightningCreateEventPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassicCalendarPage extends CalendarPage {

    @FindBy(css = "a[title='New Event']")
    private WebElement btnNewEvent;

//    private String xpathLink  = "//tr//a[contains(text(),'%s')]";
//
//    private ClassicContactDetailsPage contactDetailsPage;
//
//    private static final String TD_XPATH = "//*[%1$s][text()='%2$s']";
//    private static final String INI = "//table[@class='list']/tbody/tr[contains(@class,'dataRow')][";
//    private static final String LAST = "]";
//    private static final String LINK_CONTACT = "table.list tbody .dataCell a[href*='%s']";
//    private static final By HEADERS_BY = By.xpath("//table[@class='list']/tbody/tr[@class='headerRow']/th");
    /**
     * Constructor.
     */
    public ClassicCalendarPage() {

    }

    /**
     * Opens CreateEventPopup
     */
    public CreateEventPopup openCreateEventPop() {
        WebDriverHelper.clickElement(btnNewEvent);
        return new ClassicCreateEventPopup();
    }

//    /**
//     * Searches a contact by id contact.
//     * @param idContact
//     * @return ClassicContactDetailsPage
//     */
//    private ClassicContactDetailsPage getContactDetailsPage(final String idContact) {
//        WebElement element = findContactInTable(idContact);
//        WebDriverHelper.waitUntil(element);
//        WebDriverHelper.clickElement(element);
//        return new ClassicContactDetailsPage();
//    }
//
//    /**
//     * @param contact
//     */
//    @Override
//    public void searchContact(final String contact) {
//
//    }
//
//    /**
//     * Deletes a contact.
//     * @param idContact
//     * @return
//     */
//    @Override
//    public WebElement findContactInTable(final String idContact) {
//        String id = idContact.substring(0, idContact.length() - NUMBER);
//        WebElement element = WebDriverManager.getInstance().getWebDriver()
//                .findElement(By.cssSelector(String.format(LINK_CONTACT, id)));
//        return element;
//    }
//
//    /**
//     * Deletes Contact.
//     * @param contact
//     */
//    @Override
//    public void deleteContact(final String contact) {
//        contactDetailsPage.clickBtnDelete();
//    }
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
//        return new ClassicContactDetailsPage();
//    }
//
//    /**
//     * Creates Locator.
//     * @param contactInfo
//     * @return rowXpathLocator
//     */
//    @Override
//    public String createLocator(final HashMap<String, String> contactInfo) {
//        contactInfo.put("Name", contactInfo.get("Lastname") + ", " + contactInfo.get("Firstname"));
//        System.out.println(contactInfo);
//        Map<String, String> map = compareMap(contactInfo);
//        String rowXpathLocator = map.entrySet().stream().map(entry ->
//            String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
//            .collect(Collectors.joining(" and ", INI, LAST));
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
//            headerText.add(header.getText());
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
//        System.out.println(getDriver().findElement(HEADERS_BY));
//        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
//            if (contactInfo.containsKey(header.getText())) {
//                map.put(header.getText(), contactInfo.get(header.getText()));
//            }
//        }
//        return map;
//    }
}
