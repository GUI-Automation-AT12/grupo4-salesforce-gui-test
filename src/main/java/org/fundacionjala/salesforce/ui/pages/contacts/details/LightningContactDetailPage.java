package org.fundacionjala.salesforce.ui.pages.contacts.details;

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


    public LightningContactDetailPage() {
        WebDriverHelper.waitUntil(addTask3);
    }

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

    @Override
    public Task getTask() {
        return null;
    }

}
