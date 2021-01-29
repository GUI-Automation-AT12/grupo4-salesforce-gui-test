package org.fundacionjala.salesforce.ui.transporter;

import org.fundacionjala.salesforce.config.APIEnvironment;

public class TransporterClassicPage extends Transporter {
    /**
     * [JS] Constructor.
     */
    public TransporterClassicPage() {
        setUrl("Reports", "o/00O/o");
        setUrl("Contacts", "003/o");
        setUrl("Recycle Bin", "search/UndeletePage");
        setUrl("Opportunity", "006/o");
    }

    /**
     * [JS] Get the base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return APIEnvironment.getInstance().getBaseUrlClassic();
    }
}
