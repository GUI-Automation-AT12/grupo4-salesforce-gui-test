package org.fundacionjala.salesforce.ui.pages.opportunities.details;

import org.fundacionjala.salesforce.config.APIEnvironment;
import java.util.HashMap;
import java.util.Map;

/**
 * [RH].
 */
public class OpportunityDetailsFactory {

    private static Map<String, OpportunityDetailsPage> opportunityDetailsMap = new HashMap<>();

    /**
     * Constructor.
     */
    private OpportunityDetailsFactory() {
    }

    static {
        opportunityDetailsMap.put("lightning", new LightningOpportunityDetailsPage());
        opportunityDetailsMap.put("classic", new ClassicOpportunityDetailsPage());
    }

    /**
     * Gets a Abstract opportunityDetailsPage class.
     * @return a opportunityDetailsPage.
     */
    public static OpportunityDetailsPage getTaskDetailsPage() {
        return opportunityDetailsMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
