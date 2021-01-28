package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.JsonAccount;
import org.fundacionjala.core.utils.JsonContact;
import org.fundacionjala.salesforce.context.Context;

import java.io.IOException;
import java.util.Map;

public class CampaignHook {
    private Context context;

    public CampaignHook(final Context context) {
        this.context = context;
    }

    /**
     * Create a Campaign.
     */
    @Before(value = "@createCampaign")
    public void createAccount() throws IOException {
        Map<String, String> data = JsonContact.getInstance().getDataAsAMap("CampaignTest");
        Response response = RequestManager.post("Campaign", data.toString());
        context.getCampaign().processInformation(data);
        context.getCampaign().setIdCampaign(response.jsonPath().get("id").toString());
        context.saveData(response.asString());
    }

    /**
     * AfterHook that deletes a created Campaign.
     */
    @After(value = "@deleteCampaign")
    public void deleteCampaign() {
        RequestManager.delete("Campaign/" + context.getCampaign().getIdCampaign());
    }
}
