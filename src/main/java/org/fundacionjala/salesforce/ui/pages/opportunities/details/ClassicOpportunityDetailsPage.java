package org.fundacionjala.salesforce.ui.pages.opportunities.details;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.entities.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * [RH].
 */
public class ClassicOpportunityDetailsPage  extends OpportunityDetailsPage{

    @FindBy(id = "opp3_ileinner")
    WebElement opportunityName;

    @FindBy(id = "opp9_ileinner")
    WebElement closeDate;

    @FindBy(id = "opp11_ileinner")
    WebElement stage;

    @FindBy(id = "opp4_ileinner")
    WebElement account;

    private Opportunity opportunity;

    private String opportunityTitle = "//h2[@class='pageDescription' and contains(text(),'%s')]";

    public ClassicOpportunityDetailsPage() {
        opportunity = new Opportunity();
    }
    /**
     * This method returns the opportunity name.
     *
     * @return opportunity.
     */
    @Override
    public String getOpportunityName() {
        return WebDriverHelper.getTextElement(opportunityName);
    }

    /**
     * This method returns the stage.
     *
     * @return stage.
     */
    @Override
    public String getStage() {
        return WebDriverHelper.getTextElement(stage);
    }

    /**
     * This method returns the close date.
     *
     * @return close date.
     */
    @Override
    public String getCloseDate() {
        return WebDriverHelper.getTextElement(closeDate);
    }

    /**
     * This method returns the account.
     *
     * @return account.
     */
    @Override
    public String getAccount() {
        return WebDriverHelper.getTextElement(account);
    }

    /**
     * This method validates the title.
     *
     * @param opportunity
     * @return boolean.
     */
    @Override
    public boolean validateTitle(Opportunity opportunity) {
        return getDriver().findElement(By.xpath(String.format(opportunityTitle, opportunity.getOpportunityName()))).isDisplayed();
    }

    private void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

}
