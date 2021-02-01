package org.fundacionjala.salesforce.ui.pages.opportunities.details;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.entities.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * [RH].
 */
public class LightningOpportunityDetailsPage extends  OpportunityDetailsPage{

    @FindBy(css = "button[name='Delete']")
    WebElement deleteOpportunity;

    private String getElementXpath = "//slot[@slot='outputField']/lightning-formatted-text[text()='%s']";
    private String account = "//a/span[text()='%s']";
    private String opportunityTitle = "//slot[@slot='header']//lightning-formatted-text[text()='%s']";
    private Opportunity opportunity;

    public LightningOpportunityDetailsPage() {
        opportunity = new Opportunity();
    }
    /**
     * This method returns the opportunity name.
     *
     * @return opportunity.
     */
    @Override
    public String getOpportunityName() {
        return WebDriverHelper.getTextElement(getElement(getElementXpath, opportunity.getOpportunityName()));
    }

    /**
     * This method returns the stage.
     *
     * @return stage.
     */
    @Override
    public String getStage() {
        return WebDriverHelper.getTextElement(getElement(getElementXpath, opportunity.getStage()));
    }

    /**
     * This method returns the close date.
     *
     * @return close date.
     */
    @Override
    public String getCloseDate() {
        return WebDriverHelper.getTextElement(getElement(getElementXpath, opportunity.getCloseDate()));
    }

    /**
     * This method returns the account.
     *
     * @return account.
     */
    @Override
    public String getAccount() {
        return WebDriverHelper.getTextElement(getElement(account, opportunity.getAccountName()));
    }

    /**
     * This method validates the title.
     *
     * @param opportunity
     * @return boolean.
     */
    @Override
    public boolean validateTitle(Opportunity opportunity) {
        setOpportunity(opportunity);
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(opportunityTitle, opportunity.getOpportunityName()))));
        return getDriver().findElement(By.xpath(String.format(opportunityTitle, opportunity.getOpportunityName()))).isDisplayed();
    }

    private void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    private WebElement getElement(String xpath, String replaceValue) {
       return getDriver().findElement(By.xpath(String.format(xpath, replaceValue)));
    }
}
