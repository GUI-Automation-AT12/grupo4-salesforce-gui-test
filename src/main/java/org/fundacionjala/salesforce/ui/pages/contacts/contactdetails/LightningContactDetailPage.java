package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.utils.DateHelper;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [RH] LightningContactDetailsPage.
 */
public class LightningContactDetailPage extends ContactDetailsPage {

    private static final int SLEEP = 2000;

    @FindBy(xpath = "//button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]")
    private WebElement addTask;

    @FindBy(xpath = "//div[@class='slds-tabs_card']//div[contains(@class,'slds-combobox__form-element')]/input")
    private WebElement asset;

    @FindBy(xpath = "//div[contains(@class,'uiInput--datetime')]/input")
    private WebElement expirationDate;

    @FindBy(xpath = "//div[contains(@class,'contentWrapper')]//div[contains(@class,'entityMenu')]/div[@class='uiPopupTrigger']//a")
    private WebElement relatedWith;

    @FindBy(xpath = "//button[contains(.,'Show more actions')]")
    private WebElement btnMenu;

    @FindBy(xpath = "//a[@name='Delete']")
    private WebElement btnDelete;

    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

    @FindBy(xpath = "//a[@class='select' and contains(@href,'javascript')]")

    private String relatedElement = "div[class*='contentWrapper'] div[class*='autocompleteWrapper'] input[title*='Search %s']";
    private String subject = "//lightning-base-combobox-item[@data-value='%s']";
    private String typeOfRelation = "//li[contains(@class,'entityMenuItem')]/a[contains(@role,'menuitem') and contains(@title,'%s')]";
    private String relatedElementList = "//a[@role='option']//div[@title='%s']";
    private String status = "//a[text()='Not Started']";
    private String statusList = "//parent::li[@role='presentation']/a[text()='%s']";
    private String saveTask = "//div[contains(@class,'activeState')]//button[contains(@class,'slds-button--brand')]";
    private String createdTask = "//a[@title='%s']";

    private static final String TD_XPATH = "*[%1$s]//*[text()='%2$s']";
    private static final String INI = "//tbody/tr[";
    private static final String LAST = "]";
    private static final String LINK_CONTACT = "//tbody//a[contains(@data-aura-class, 'Output')][@data-recordid='%s']";
    private static final By HEADERS_BY = By.cssSelector("table[data-aura-class='uiVirtualDataTable'] thead tr th");
    private String contactTitle = "//span[contains(text(),'%s')]";
    private String contactListed = "//tbody//a[contains(@href,'%s')]";
    private String linkEvent = "//a[contains(@class,'subjectLink')][text()='%s']";

    /**
     * Constructor.
     */
    public LightningContactDetailPage() {
        WebDriverHelper.waitUntil(addTask);
         task = new Task();
    }

    /**
     * Click in button Menu.
     */
    public void clickButtonMenu() {
        try {
            WebDriverHelper.waitUntil(btnMenu);
            WebDriverHelper.clickElement(btnMenu);
        } catch (Exception ex) {
            WebDriverHelper.clickElement(btnMenu);
        }
    }

    /**
     * this method select the relation and the relation value.
     */
    private void relatedTo() {
        try {
            Thread.sleep(SLEEP);
            JavascriptHelper.clickElement(relatedWith); //
            By dropDownRelatedWith = By.xpath(String.format(typeOfRelation, getTask().getRelatedWith()));
            WebDriverHelper.clickElement(dropDownRelatedWith); //
            WebElement related = getDriver().findElement(By.cssSelector(String.format(relatedElement, getTask().getRelatedWith())));
            WebDriverHelper.setElement(related, getTask().getRelatedValue());
            WebElement elementOnList = getDriver().findElement(By.xpath(String.format(relatedElementList, getTask().getRelatedValue())));
            JavascriptHelper.clickElement(elementOnList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method creates a task.
     * @param taskInformation
     */
    public void createTask(final Map<String, String> taskInformation) {
        getTask().processInformation(taskInformation);
        JavascriptHelper.clickElement(addTask);
        WebDriverHelper.setElement(asset, getTask().getSubject());
        WebDriverHelper.clickElement(By.xpath(String.format(subject, getTask().getSubject())));
        WebDriverHelper.setElement(expirationDate, getTask().getDueDate());
        relatedTo();
        JavascriptHelper.clickElement(getDriver().findElement(By.xpath(status)));
        JavascriptHelper.clickElement(getDriver().findElement(By.xpath(String.format(statusList, getTask().getState()))));
        getTask().setCreationDate(DateHelper.getActualDate());
        JavascriptHelper.clickElement(getDriver().findElement(By.xpath(saveTask)));
        selectCreatedTask(getTask());
    }

    /**
     * Select the created task.
     * @param task
     */
    public void selectCreatedTask(final Task task) {
        JavascriptHelper.clickElement(getDriver().findElement(By.xpath(String.format(createdTask, task.getSubject()))));
    }

    /**
     * @return task
     */
    @Override
    public Task getTask() {
        return task;
    }

    /**
     * Clicks in button delete.
     */
    public void clickBtnDelete() {
        WebDriverHelper.clickElement(btnDelete);
    }

    /**
     * Click in button delete.
     */
    public void clickBtnConfirmDelete() {
        WebDriverHelper.clickElement(btnConfirmDelete);
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void deleteContact() {
        clickButtonMenu();
        clickBtnDelete();
        clickBtnConfirmDelete();
    }

    /**
     * Verifies if element is loaded.
     */
    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntilIsVisible(btnMenu);
    }

    /**
     * @param contactInfo
     * @return locator
     */
    @Override
    public String createLocator(final HashMap<String, String> contactInfo) {
        return String.format(linkEvent, contactInfo.get("Subject"));
//        contactInfo.put("Name", contactInfo.get("Firstname") + " " + contactInfo.get("Lastname"));
//        Map<String, String> map = compareMap(contactInfo);
//        String rowXpathLocator = map.entrySet().stream().map(entry ->
//                String.format(TD_XPATH, getHeaderPosition(entry.getKey().toString()), entry.getValue()))
//                .collect(Collectors.joining(" and ", INI, LAST));
//        return rowXpathLocator;
    }

    /**
     * Gets header position.
     * @param key
     * @return HeaderPosition
     */
    private String getHeaderPosition(final String key) {
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
            headerText.add(header.getAttribute("aria-label"));
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
        System.out.println(getDriver().findElements(HEADERS_BY));
        for (WebElement header : getDriver().findElements(HEADERS_BY)) {
            if (contactInfo.containsKey(header.getAttribute("aria-label"))) {
                map.put(header.getAttribute("aria-label"), contactInfo.get(header.getAttribute("aria-label")));
            }
        }
        return map;
    }
}
