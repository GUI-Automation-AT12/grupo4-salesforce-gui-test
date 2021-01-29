package org.fundacionjala.salesforce.ui.forms;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Opportunity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

/**
 * [RH].
 */
public class ClassicOpportunityForm extends OpportunityForm {

    @FindBy(id = "opp3")
    WebElement opportunityName;

    @FindBy(id = "opp4")
    WebElement account;

    @FindBy(id = "opp9")
    WebElement closeDate;

    @FindBy(id = "opp11")
    WebElement stage;

    @FindBy(css = "input[name='save']")
    WebElement saveOpportunity;

    private Opportunity opportunity;

    public ClassicOpportunityForm() {
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
        JavascriptHelper.clickElement(saveOpportunity);
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
        Select dropdownStage = new Select(stage);
        dropdownStage.selectByVisibleText(opportunity.getStage());
    }

    /**
     * [RH] sets the account.
     */
    @Override
    protected void setAccount() {
        WebDriverHelper.setElement(account, opportunity.getAccountName());
    }
}
