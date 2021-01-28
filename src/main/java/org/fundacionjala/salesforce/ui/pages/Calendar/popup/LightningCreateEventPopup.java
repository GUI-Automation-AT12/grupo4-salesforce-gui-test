package org.fundacionjala.salesforce.ui.pages.Calendar.popup;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class LightningCreateEventPopup extends CreateEventPopup {

    @FindBy(css = "div.isModal button[title='Save']")
    private WebElement btnSave;

    @FindBy(xpath = "//span[text()='Location']/parent::label/following-sibling::input")
    private WebElement location;

    @FindBy(xpath = "//label[text()='Subject']/following-sibling::div//input")
    private WebElement subject;

    @FindBy(xpath = "//legend[text()='Start']/following-sibling::div//label[text()='Date']/following-sibling::div//input")
    private WebElement startDate;

    @FindBy(xpath = "//legend[text()='Start']/following-sibling::div//label[text()='Time']/following-sibling::div//input")
    private WebElement startTime;

    @FindBy(xpath = "//legend[text()='End']/following-sibling::div//label[text()='Date']/following-sibling::div//input")
    private WebElement endDate;

    @FindBy(xpath = "//legend[text()='End']/following-sibling::div//label[text()='Time']/following-sibling::div//input")
    private WebElement endTime;

    @FindBy(xpath = "//span[text()='Name']/parent::label/following-sibling::div//a")
    private WebElement selectUser;

    @FindBy(xpath = "//span[text()='Name']/parent::label/following-sibling::div//input")
    private WebElement nameUser;

    @FindBy(xpath = "//span[text()='Related To']/parent::label/following-sibling::div//a")
    private WebElement selectEntity;

    @FindBy(xpath = "//span[text()='Related To']/parent::label/following-sibling::div//input")
    private WebElement nameEntity;

    private String typeOfTeam = "//*[contains(text(),'%s')]";

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
        WebDriverHelper.clickElement(btnSave);
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
        strategyMap.put("StartTime", () -> setStartTime(information.get("StartTime")));
        strategyMap.put("SelectUser", () -> setSelectUser(information.get("SelectUser")));
        strategyMap.put("Name", () -> setNameUser(information.get("Name")));
        strategyMap.put("SelectEntity", () -> setSelectEntity(information.get("SelectEntity")));
        strategyMap.put("RelatedTo", () -> setNameEntity(information.get("RelatedTo")));
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
        WebDriverHelper.setElement(startDate, newStartDate);
    }

    /**
     *
     * @param newStartTime
     */
    public void setStartTime(final String newStartTime) {
        WebDriverHelper.setElement(startTime, newStartTime);
    }

    /**
     *
     * @param newEndDate
     */
    public void setEndDate(final String newEndDate) {
        WebDriverHelper.setElement(endDate, newEndDate);

    }

    /**
     *
     * @param newEndTime
     */
    public void setEndTime(final String newEndTime) {
        WebDriverHelper.setElement(endDate, newEndTime);
    }

    /**
     *
     * @param newSelectUser
     */
    public void setSelectUser(final String newSelectUser) {
        selectDropDownOptionByName(selectUser,newSelectUser);
    }

    /**
     *
     * @param newSelectEntity
     */
    public void setSelectEntity(final String newSelectEntity) {
        selectDropDownOptionByName(selectEntity,newSelectEntity);
    }

    /**
     * Selects an element from a html select tag.
     * @param newData
     */
    private void selectDropDownOptionByName(final WebElement element, final String newData) {
        WebDriverHelper.clickElement(element);
        By dropDownTeam = By.xpath(String.format(typeOfTeam, newData));
        WebDriverHelper.clickElement(dropDownTeam);
    }

    /**
     *
     * @param newNameUser
     */
    public void setNameUser(final String newNameUser) {
        WebDriverHelper.setElement(nameUser, newNameUser);
        nameUser.sendKeys(Keys.ENTER);
    }

    /**
     *
     * @param newNameEntity
     */
    public void setNameEntity(final String newNameEntity) {
        WebDriverHelper.setElement(nameEntity, newNameEntity);
        nameEntity.sendKeys(Keys.ENTER);
    }
}
