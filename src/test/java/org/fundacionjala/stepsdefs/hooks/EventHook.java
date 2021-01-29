package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.JsonContact;
import org.fundacionjala.salesforce.context.Context;

import java.io.IOException;
import java.util.Map;

public class EventHook {
    private Context context;

    public EventHook(final Context context) {
        this.context = context;
    }


    /**
     * AfterHook that deletes a created Campaign.
     */
    @After(value = "@deleteEvent", order = 5)
    public void deleteEvent() {
        RequestManager.delete("Event/" + context.getEvent().getIdEvent());
    }
}
