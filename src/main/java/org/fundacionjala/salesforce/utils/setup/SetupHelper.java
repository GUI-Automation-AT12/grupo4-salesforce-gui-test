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
public class SetupHelper {

    private static final String CONTACT_ENDPOINT = "Contact";
    private static final String CAMPAIGN_ENDPOINT = "Campaign";
    private static final String OPPORTUNITY_ENDPOINT = "Opportunity";
    private static final String CASE_ENDPOINT = "Case";
    private SetupReader setupReader;
    private static Map<String, String> elementName = new HashMap<>();
    static {
        elementName.put(CONTACT_ENDPOINT, "LastName, firstName");
        elementName.put(CAMPAIGN_ENDPOINT, "Name");
        elementName.put(OPPORTUNITY_ENDPOINT, "Name");
    }

    /**
     * Constructor.
     */
    public SetupHelper() {
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        setupReader = new SetupReader();
    }

    /**
     * [RH] Setup contacts.
     */
    public void setupContacts() {
        sendRequests(CONTACT_ENDPOINT, setupReader.getConvertedContactSheet());
    }

    /**
     * [RH] Setup campaigns.
     */
    public void setupCampaigns() {
        sendRequests(CAMPAIGN_ENDPOINT, setupReader.getConvertedCampaignSheet());
    }

    /**
     * [RH] Setup opportunities.
     */
    public void setupOpportunities() {
        sendRequests(OPPORTUNITY_ENDPOINT, setupReader.getConvertedOpportunitySheet());
    }

    /**
     * [RH] Setup cases.
     */
    public void setupCases() {
        sendRequests(CASE_ENDPOINT, setupReader.getConvertedCaseSheet());
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
                String[] array = elementName.get(endpoint).split(",");
                String name = "";
                for (int i = 0; i < array.length; i++) {
                    name += json.getString(array[i]);
                    if (i < array.length - 1) {
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
