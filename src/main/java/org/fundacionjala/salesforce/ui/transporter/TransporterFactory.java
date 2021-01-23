package org.fundacionjala.salesforce.ui.transporter;

import java.util.HashMap;
import java.util.Map;

public final class TransporterFactory {
    private static Map<String, Transporter> transporters = new HashMap<>();

    /**
     * [JS] Constructor.
     */
    private TransporterFactory() { }
    static {
        transporters.put("lighting", new TransporterLightingPage());
        transporters.put("classic", new TransporterClassicPage());
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
