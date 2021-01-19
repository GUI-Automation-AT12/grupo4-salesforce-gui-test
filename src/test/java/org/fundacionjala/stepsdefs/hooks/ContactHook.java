package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.salesforce.context.Context;

import java.io.IOException;

public class ContactHook {
    private Context context;

    public ContactHook(final Context context) {
        this.context = context;
    }

    /**
     *
     */
    @Before(value = "@createContact")
    public void createContact() throws IOException {
        Response response = RequestManager.post("Contact", "{\"firstName\" : \"Contacto\", \"lastName\" : \"Example Account\"}");
        this.context.saveData(response.asString());
    }

    /**
     * AfterHook that deletes a created Account.
     */
    @After(value = "@deleteContact")
    public void deleteAccount() {
    }
}
