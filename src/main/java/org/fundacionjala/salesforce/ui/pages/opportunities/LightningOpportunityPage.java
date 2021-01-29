package org.fundacionjala.salesforce.ui.pages.opportunities;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.forms.LightningOpportunityForm;
import org.fundacionjala.salesforce.ui.forms.OpportunityForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightningOpportunityPage extends OpportunityPage{

    @FindBy(css = "a[title='New']")
    WebElement addOpportunity;

    public LightningOpportunityPage() {
        opportunityForm = new LightningOpportunityForm();
    }

    /**
     * [RH] This method opens the form to create an opportunity.
     */
    @Override
    public void addOpportunity() {
        WebDriverHelper.clickElement(addOpportunity);
    }


    /**
     * [RH] This method returns form to create an opportunity.
     *
     * @return Opportunity form.
     */
    @Override
    public OpportunityForm getOpportunityForm() {
        return opportunityForm;
    }
}
