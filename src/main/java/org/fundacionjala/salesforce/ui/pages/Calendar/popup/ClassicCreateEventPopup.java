package org.fundacionjala.salesforce.ui.pages.Calendar.popup;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.utils.DateHelper;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class ClassicCreateEventPopup extends CreateEventPopup {

    @FindBy(id = "publishersharebutton")
    private WebElement btnSave;

    @FindBy(css = " input[data-fieldname='location']")
    private WebElement location;

    @FindBy(css = " input[data-fieldname='subject'][id^='evt']")
    private WebElement subject;

    @FindBy(css = "form span.dateOnlyInput input[name^='StartDateTime']")
    private WebElement startDate;

    @FindBy(css = "form span.timeInput input[name^='StartDateTime']")
    private WebElement startTime;

    @FindBy(css = "form span.dateOnlyInput input[name^='EndDateTime']")
    private WebElement endDate;

    @FindBy(css = "form span.timeInput input[name^='EndDateTime']")
    private WebElement endTime;

    private Select selectUser = new Select(getDriver().findElement(
            By.xpath("//label[text()='Name']/parent::div/following-sibling::div/*[starts-with(@id, 'evt')]")));
    private Select selectEntity = new Select(getDriver().findElement(
            By.xpath("//label[text()='Related To']/parent::div/following-sibling::div/*[starts-with(@id, 'evt')]")));

    @FindBy(css = "span.lookupInput input[title='Name']")
    private WebElement nameUser;

    @FindBy(css = "span.lookupInput input[title='Related To']")
    private WebElement nameEntity;
    private DateHelper dateHelper = new DateHelper();

    /**
     * Constructor.
     */
    public ClassicCreateEventPopup() {
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
        strategyMap.put("StartTime", () -> setStartTime(information.get("StartTime")));
        strategyMap.put("EndDate", () -> setEndDate(information.get("EndDate")));
        strategyMap.put("EndTime", () -> setEndTime(information.get("EndTime")));
        strategyMap.put("Select Name", () -> setSelectUser(information.get("Select Name")));
        strategyMap.put("Name", () -> setNameUser(information.get("Name")));
        strategyMap.put("Select RelatedTo", () -> setSelectEntity(information.get("Select RelatedTo")));
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
        WebDriverHelper.setElement(startDate, dateHelper.getDate(newStartDate));
    }

    /**
     *
     * @param newStartTime
     */
    public void setStartTime(final String newStartTime) {
        WebDriverHelper.setElement(startTime, dateHelper.getDate(newStartTime));
    }

    /**
     *
     * @param newEndDate
     */
    public void setEndDate(final String newEndDate) {
        WebDriverHelper.setElement(endDate, dateHelper.getDate(newEndDate));

    }

    /**
     *
     * @param newEndTime
     */
    public void setEndTime(final String newEndTime) {
        WebDriverHelper.setElement(endTime, dateHelper.getDate(newEndTime));
    }

    /**
     *
     * @param newSelectUser
     */
    public void setSelectUser(final String newSelectUser) {
        selectUser.selectByVisibleText(newSelectUser);
    }

    /**
     *
     * @param newSelectEntity
     */
    public void setSelectEntity(final String newSelectEntity) {
        selectEntity.selectByVisibleText(newSelectEntity);
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
