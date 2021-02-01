package org.fundacionjala.salesforce.ui.pages.opportunities.details;

import org.fundacionjala.salesforce.entities.Opportunity;
import org.fundacionjala.salesforce.ui.pages.BasePage;

/**
 * [RH].
 */
public abstract class OpportunityDetailsPage  extends BasePage {

    /**
     * This method returns the opportunity name.
     * @return opportunity.
     */
    public abstract String getOpportunityName();

    /**
     * This method returns the stage.
     * @return stage.
     */
    public abstract String getStage();

    /**
     * This method returns the close date.
     * @return close date.
     */
    public abstract String getCloseDate();

    /**
     * This method returns the account.
     * @return account.
     */
    public abstract String getAccount();

    /**
     * This method validates the title.
     * @return boolean.
     */
    public abstract boolean validateTitle(Opportunity opportunity);
}
