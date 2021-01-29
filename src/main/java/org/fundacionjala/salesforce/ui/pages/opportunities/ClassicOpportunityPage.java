package org.fundacionjala.salesforce.ui.pages.opportunities;

import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.ui.forms.ClassicOpportunityForm;
import org.fundacionjala.salesforce.ui.forms.OpportunityForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassicOpportunityPage extends  OpportunityPage{

    @FindBy(css = "input[name='new']")
    WebElement addOpportunity;

    public ClassicOpportunityPage() {
        opportunityForm = new ClassicOpportunityForm();
    }

    /**
     * [RH] This method opens the form to create an opportunity.
     */
    @Override
    public void addOpportunity() {
        JavascriptHelper.clickElement(addOpportunity);
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
