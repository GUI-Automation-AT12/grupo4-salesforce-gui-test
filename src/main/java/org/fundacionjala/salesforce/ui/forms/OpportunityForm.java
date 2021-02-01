package org.fundacionjala.salesforce.ui.forms;

import org.fundacionjala.salesforce.entities.Opportunity;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import java.util.Map;

/**
 * [RH].
 */
public abstract class OpportunityForm extends BasePage {

    /**
     * [RH] This method sets the data in the form.
     * @param opportunityInformation
     */
    public abstract void setData(Map<String, String> opportunityInformation, String account);

    /**
     * [RH] This method saves the opportunity.
     */
    public abstract void saveOpportunity();

    /**
     * [RH] This method returns the opportunity.
     * @return
     */
    public abstract Opportunity getOpportunity();

    /**
     * [RH] sets the opportunity name.
     */
    protected abstract void setOpportunityName();

    /**
     * [RH] sets the close date.
     */
    protected abstract void setCloseDate();

    /**
     * [RH] sets the stage.
     */
    protected abstract void setStage();

    /**
     * [RH] sets the account.
     */
    protected abstract void setAccount();
}
