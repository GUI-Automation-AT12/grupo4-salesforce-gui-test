package org.fundacionjala.salesforce.ui.pages.opportunities;

import org.fundacionjala.salesforce.config.APIEnvironment;
import java.util.HashMap;
import java.util.Map;

/**
 * [RH].
 */
public class OpportunityFactory {

    private static Map<String, OpportunityPage> opportunityMap = new HashMap<>();

    /**
     * Constructor.
     */
    private OpportunityFactory() {
    }

    static {
        opportunityMap.put("lightning", new LightningOpportunityPage());
        opportunityMap.put("classic", new ClassicOpportunityPage());
    }

    /**
     * Gets a Abstract opportunityPage class.
     * @return a opportunityPage.
     */
    public static OpportunityPage getOpportunityPage() {
        return opportunityMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
