package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class LightningContactDetailPage extends ContactDetailsPage {

    //button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]/preceding-sibling::button
    @FindBy(css = ".slds-button--brand")
    private WebElement addTask;

    @FindBy(xpath = "//button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]/preceding-sibling::button")
    private WebElement addTask2;

    @FindBy(xpath = "//button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]")
    private WebElement addTask3;

    @FindBy(css = "slds-button--brand")
    private WebElement addTask4;

    @FindBy(css = "div[class='slds-tabs_card'] div[class*='slds-combobox__form-element']")
    private WebElement asset;

    @FindBy(css = "uiInput--datetime")
    private WebElement expirationDate;

    @FindBy(css = "div[data-proxy-id='aura-pos-lib-1']")
    private WebElement relatedWith;

    @FindBy(xpath = "//div[@data-proxy-id='aura-pos-lib-1']/parent::div/parent::div/following-sibling::div")
    private WebElement relatedElement;

    @FindBy(xpath = "//a[@class='select' and contains(@href,'javascript')]")
    private WebElement state;

    @FindBy(xpath = "//button[contains(.,'Show more actions')]")
    private WebElement btnMenu;

    @FindBy(xpath = "//a[@name='Delete']")
    private WebElement btnDelete;

    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

    /**
     * Click in button Menu.
     */
    public void clickButtonMenu() {
        WebDriverHelper.clickElement(btnMenu);
    }

    /**
     * @param taskInformation
     */
    @Override
    public void createTask(Map<String, String> taskInformation) {
        //WebElement contact = driver.findElement(By.xpath("//button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]"));
        //WebDriverHelper.waitUntil(contact);
        //WebDriverHelper.clickElement(contact);
        WebDriverHelper.clickElement(driver.findElement(By.cssSelector(".slds-button--brand > .label")));
        task.processInformation(taskInformation);
        WebDriverHelper.setElement( asset, task.getSubject());
        WebDriverHelper.setElement( expirationDate, task.getDueDate());
        WebDriverHelper.setElement( relatedWith, task.getRelatedWith());
        WebDriverHelper.setElement( relatedElement, task.getRelatedValue());
        WebDriverHelper.setElement( state, task.getState());

    }

    /**
     * @return task
     */
    @Override
    public Task getTask() {
        return null;
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


}
