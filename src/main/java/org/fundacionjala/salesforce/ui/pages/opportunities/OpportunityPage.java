package org.fundacionjala.salesforce.ui.pages.opportunities;

import org.fundacionjala.salesforce.ui.forms.OpportunityForm;
import org.fundacionjala.salesforce.ui.pages.BasePage;

/**
 * [RH].
 */
public abstract class OpportunityPage extends BasePage {

    protected OpportunityForm opportunityForm;

    /**
     * [RH] This method opens the form to create an opportunity.
     */
    public abstract void addOpportunity();


    /**
     * [RH] This method returns form to create an opportunity.
     * @return Opportunity form.
     */
    public abstract OpportunityForm getOpportunityForm();
}
