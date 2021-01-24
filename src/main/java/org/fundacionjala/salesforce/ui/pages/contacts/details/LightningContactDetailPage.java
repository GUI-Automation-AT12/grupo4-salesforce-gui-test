package org.fundacionjala.salesforce.ui.pages.contacts.details;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightningContactDetailPage extends ContactDetailsPage {

    @FindBy(css = "button[class*='slds-button--brand testid__dummy-button-submit-action']")
    WebElement addTask;

    @FindBy(css = "div[class='slds-tabs_card'] div[class*='slds-combobox__form-element']")
    WebElement asset;

    @FindBy(css = "uiInput--datetime")
    WebElement dueDate;

    @FindBy(css = "div[data-proxy-id='aura-pos-lib-1']")
    WebElement relatedWith;

    @FindBy(xpath = "//div[@data-proxy-id='aura-pos-lib-1']/parent::div/parent::div/following-sibling::div")
    WebElement relatedElement;

    @FindBy(xpath = "//a[@class='select' and contains(@href,'javascript')]")
    WebElement state;

    
}
