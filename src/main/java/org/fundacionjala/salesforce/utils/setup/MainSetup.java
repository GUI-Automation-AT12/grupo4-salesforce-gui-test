package org.fundacionjala.salesforce.utils.setup;

import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.SetupReader;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.utils.AuthenticationUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [RH] Setup helper class.
 */
public class MainSetup {

    private static final String CONTACT_SHEET = "Contact";
    private static final String CAMPAIGN_SHEET = "Campaign";
    private static final String OPPORTUNITY_SHEET = "Opportunity";
    private static final String CASE_SHEET = "Cases";
    private SetupReader setupReader;
    private static Map<String, String> elementName = new HashMap<>();
    static {
        elementName.put(CONTACT_SHEET, "LastName,firstName");
        elementName.put(CAMPAIGN_SHEET, "Name");
        elementName.put(OPPORTUNITY_SHEET, "Name");
    }

    /**
     * Constructor.
     */
    public MainSetup() {
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        setupReader = new SetupReader();
    }

    /**
     * [RH] Setup contacts.
     */
    public void setupContacts() {
        sendRequests(CONTACT_SHEET, setupReader.getConvertedContactSheet());
    }

    /**
     * [RH] Setup campaigns.
     */
    public void setupCampaigns() {
        sendRequests(CAMPAIGN_SHEET, setupReader.getConvertedCampaignSheet());
    }

    /**
     * [RH] Setup opportunities.
     */
    public void setupOpportunities() {
        sendRequests(OPPORTUNITY_SHEET, setupReader.getConvertedOpportunitySheet());
    }

    /**
     * [RH] Setup cases.
     */
    public void setupCases() {
        sendRequests(CASE_SHEET, setupReader.getConvertedCaseSheet());
    }

    /**
     * [RH] Send requests from a list.
     * @param endpoint
     * @param jsonList
     */
    private static void sendRequests(final String endpoint, final List<JSONObject> jsonList) {
        try {
            Response resp = RequestManager.get(endpoint);
            Context context  = new Context();
            context.saveData(resp.asString());
            Map<String, String> data = context.getData();
            List<JSONObject> list = jsonList;
            for (JSONObject json : jsonList) {
                String[] search = elementName.get(endpoint).split(",");
                String name = "";
                for (int i = 0; i < search.length; i++) {
                    name += json.getString(search[i]);
                    if (i < search.length - 1) {
                        name += ", ";
                    }
                }
                if (!existsElement(name, resp)) {
                    Response response = RequestManager.post(endpoint, json.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean existsElement(final String newElementName, final Response response) {
        boolean exists = false;
        JSONObject responseAsJson = new JSONObject(response.asString());
        JSONArray listOfElements = new JSONArray(responseAsJson.getJSONArray("recentItems").toString());
        for (int i = 0; i < listOfElements.length(); i++) {
            JSONObject elementInList = listOfElements.getJSONObject(i);
            String name = elementInList.getString("Name");
            if (name.equals(newElementName)) {
                exists = true;
            }
        }
        return exists;
    }
}
