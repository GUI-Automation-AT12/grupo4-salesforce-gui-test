package org.fundacionjala.salesforce.ui.pages.Calendar.popup;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.utils.DateHelper;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class LightningCreateEventPopup extends CreateEventPopup {

    @FindBy(css = "div.isModal button[title='Save']")
    private WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//span[text()='Location']/parent::label/following-sibling::input")
    private WebElement location;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//label[text()='Subject']/following-sibling::div//input")
    private WebElement subject;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//legend[text()='Start']/following-sibling::div//label[text()='Date']/following-sibling::div//input")
    private WebElement startDate;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//legend[text()='Start']/following-sibling::div//label[text()='Time']/following-sibling::div//input")
    private WebElement startTime;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//legend[text()='End']/following-sibling::div//label[text()='Date']/following-sibling::div//input")
    private WebElement endDate;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//legend[text()='End']/following-sibling::div//label[text()='Time']/following-sibling::div//input")
    private WebElement endTime;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//span[text()='Name']/parent::label/following-sibling::div//a[@role='button']")
    private WebElement btnSelectUser;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//span[text()='Name']/parent::label/following-sibling::div//input")
    private WebElement nameUserTextBox;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//span[text()='Related To']/parent::label/following-sibling::div//a[@role='button']")
    private WebElement btnSelectEntity;

    @FindBy(xpath = "//div[contains(@class,'isModal')]//span[text()='Related To']/parent::label/following-sibling::div//input")
    private WebElement nameEntityTextBox;

    private static final String LOCATOR_TYPE_ENTITY = "//li[contains(@class,'entityMenuItem%s ')]/a";
    private static final String LOCATOR_TYPE_DATA = "//div[contains(@class,'isModal')]//div[@title='%s']/ancestor::a[@role='option']";
    private DateHelper dateHelper = new DateHelper();
    private static HashMap<String, String> HEADER_CLASS_MAP = new HashMap<>();
    static {
        HEADER_CLASS_MAP.put("Product", "Product2");
    }

    /**
     * Constructor.
     */
    public LightningCreateEventPopup() {

    }


    /**
     * @param information
     */
    @Override
    public void createEvent(final Map<String, String> information) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(information);
        information.keySet().forEach(key -> strategyMap.get(key).run());
        JavascriptHelper.clickElement(btnSave);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Compose a strategy map.
     * @param information
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> information) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Location", () -> setLocation(information.get("Location")));
        strategyMap.put("Subject", () -> setSubject(information.get("Subject")));
        strategyMap.put("StartDate", () -> setStartDate(information.get("StartDate")));
        strategyMap.put("EndDate", () -> setEndDate(information.get("EndDate")));
        strategyMap.put("StartTime", () -> setStartTime(information.get("StartTime")));
        strategyMap.put("EndTime", () -> setEndTime(information.get("EndTime")));
        strategyMap.put("Select Name", () -> setBtnSelectUser(information.get("Select Name")));
        strategyMap.put("Name", () -> setNameUserTextBox(information.get("Name")));
        strategyMap.put("Select RelatedTo", () -> setBtnSelectEntity(information.get("Select RelatedTo")));
        strategyMap.put("RelatedTo", () -> setNameEntityTextBox(information.get("RelatedTo")));
        return strategyMap;
    }

    /**
     *
     * @return location
     */
    public String getLocation() {
        return WebDriverHelper.getValue(location);
    }

    /**
     *
     * @param newLocation
     */
    public void setLocation(final String newLocation) {
        WebDriverHelper.setElement(location, newLocation);
    }

    /**
     *
     * @return subject
     */
    public String getSubject() {
        return WebDriverHelper.getValue(subject);
    }

    /**
     *
     * @param newSubject
     */
    public void setSubject(final String newSubject) {
        WebDriverHelper.setElement(subject, newSubject);
    }

    /**
     *
     * @param newStartDate
     */
    public void setStartDate(final String newStartDate) {
        WebDriverHelper.setElement(startDate, dateHelper.getDate(newStartDate));
    }

    /**
     *
     * @param newStartTime
     */
    public void setStartTime(final String newStartTime) {
//        startDate.clear();
//        WebDriverHelper.setElement(startTime, dateHelper.getDate(newStartTime));
    }

    /**
     *
     * @param newEndDate
     */
    public void setEndDate(final String newEndDate) {
        endDate.clear();
        WebDriverHelper.setElement(endDate, dateHelper.getDate(newEndDate));

    }

    /**
     *
     * @param newEndTime
     */
    public void setEndTime(final String newEndTime) {
//        WebDriverHelper.setElement(endTime, dateHelper.getDate(newEndTime));
    }

    /**
     *
     * @param newSelectUser
     */
    public void setBtnSelectUser(final String newSelectUser) {
        JavascriptHelper.clickElement(btnSelectUser);
        selectDropDownOption(LOCATOR_TYPE_ENTITY, newSelectUser);
    }

    /**
     *
     * @param newSelectEntity
     */
    public void setBtnSelectEntity(final String newSelectEntity) {
        JavascriptHelper.clickElement(btnSelectEntity);
        selectDropDownOption(LOCATOR_TYPE_ENTITY, getClassValue(newSelectEntity));
    }

    /**
     * Selects an element from a html select tag.
     * @param newData
     */
    private void selectDropDownOption(final String locator, final String newData) {
        By dropDownTeam = By.xpath(String.format(locator, newData));
        JavascriptHelper.clickElement(getDriver().findElement(dropDownTeam));
    }

    /**
     *
     * @param newNameUser
     */
    public void setNameUserTextBox(final String newNameUser) {
        WebDriverHelper.setElement(nameUserTextBox, newNameUser);
        selectDropDownOption(LOCATOR_TYPE_DATA, newNameUser);
    }

    /**
     *
     * @param newNameEntity
     */
    public void setNameEntityTextBox(final String newNameEntity) {
        WebDriverHelper.setElement(nameEntityTextBox, newNameEntity);
        selectDropDownOption(LOCATOR_TYPE_DATA, newNameEntity);
    }

    /**
     *
     * @param header
     * @return
     */
    private static String getClassValue(final String header) {
        return HEADER_CLASS_MAP.getOrDefault(header,header);
    }
}
