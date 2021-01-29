package org.fundacionjala.salesforce.ui.forms;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * [RH].
 */
public class LightningOpportunityForm extends OpportunityForm {

    @FindBy(css = "div[class='inlineFooter'] button[title='Save']")
    WebElement saveOpportunity;

    @FindBy(css = "div[class='form-element'] input")
    WebElement closeDate;

    @FindBy(xpath = "//div[contains(@class,'inputWrapper')]//div[contains(@class,'autocompleteWrapper')]/input[@title='Search Accounts']")
    WebElement account;

    @FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/following-sibling::input")
    WebElement opportunityName;

    private String stage = "//a[text()='--None--']";
    private String stageList = "//ul[@role='presentation']//a[text()='%s']";
    private String accountList = "//ul[contains(@class,'lookup__list')]//div[@title='%s']//ancestor::a[@role='option']";
    private Opportunity opportunity;

    public LightningOpportunityForm() {
        opportunity =  new Opportunity();
    }
    /**
     * [RH] This method sets the data in the form.
     *
     * @param opportunityInformation
     */
    @Override
    public void setData(Map<String, String> opportunityInformation, String account) {
        opportunity.processInformation(opportunityInformation);
        opportunity.setAccountName(account);
        setOpportunityName();
        setAccount();
        setCloseDate();
        setStage();
    }

    /**
     * [RH] This method saves the opportunity.
     */
    @Override
    public void saveOpportunity() {
        WebDriverHelper.clickElement(saveOpportunity);
    }

    /**
     * This method returns the opportunity.
     * @return
     */
    public Opportunity getOpportunity() {
        return opportunity;
    }

    /**
     * [RH] sets the opportunity name.
     */
    @Override
    protected void setOpportunityName() {
        WebDriverHelper.waitUntil(opportunityName);
        WebDriverHelper.setElement(opportunityName, opportunity.getOpportunityName());
    }

    /**
     * [RH] sets the close date.
     */
    @Override
    protected void setCloseDate() {
        WebDriverHelper.setElement(closeDate, opportunity.getCloseDate());
    }

    /**
     * [RH] sets the stage.
     */
    @Override
    protected void setStage() {
      WebDriverHelper.clickElement(By.xpath(stage));
      JavascriptHelper.clickElement(getDriver().findElement(By.xpath(String.format(stageList, opportunity.getStage()))));
    }

    /**
     * [RH] sets the account.
     */
    @Override
    protected void setAccount() {
        WebDriverHelper.setElement(account, opportunity.getAccountName());
        JavascriptHelper.clickElement(getDriver().findElement(By.xpath(String.format(accountList, opportunity.getAccountName()))));
    }

}
