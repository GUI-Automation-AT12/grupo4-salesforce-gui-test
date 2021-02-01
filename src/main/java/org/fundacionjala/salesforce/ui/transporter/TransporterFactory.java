package org.fundacionjala.salesforce.ui.transporter;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.CLASSIC;
import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.LIGHTNING;

public final class TransporterFactory {
    private static Map<String, Transporter> transporters = new HashMap<>();

    /**
     * [JS] Constructor.
     */
    private TransporterFactory() { }
    static {
        transporters.put(LIGHTNING, new TransporterLightingPage());
        transporters.put(CLASSIC, new TransporterClassicPage());
    }

    /**
     * [JS] Used for select a Transporter.
     * @param transporter Parameter content a Transporter Name.
     * @return a Transporter.
     */
    public static Transporter getTransporter(final String transporter) {
        return transporters.get(transporter);
    }
}
