package org.fundacionjala.salesforce.ui.transporter;

import org.fundacionjala.salesforce.config.APIEnvironment;

public class TransporterLightingPage extends Transporter {

    /**
     * [JS] Constructor.
     */
    public TransporterLightingPage() {
        setUrl("CompanyProfile", "setup/CompanyProfileInfo/home");
        setUrl("Setup", "setup/SetupOneHome/home");
        setUrl("Contacts", "o/Contact/list?filterName=Recent");
        setUrl("Tasks", "o/Task/home");
        setUrl("Reports", "o/Report/home?queryScope=mru");
        setUrl("Calendar", "o/Event/home");
        setUrl("Recycle Bin", "o/DeleteEvent/list?filterName=");
        setUrl("Opportunity", "o/Opportunity/list?filterName=Recent");
    }

    /**
     * [JS] Get the base url.
     * @return the base url
     */
    public String getBaseUrl() {
        return APIEnvironment.getInstance().getBaseUrlLighting();
    }
}
