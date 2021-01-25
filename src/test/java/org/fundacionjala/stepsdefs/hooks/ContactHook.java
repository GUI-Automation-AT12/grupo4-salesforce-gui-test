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
     * Create a contact
     */
    @Before(value = "@createContact")
    public void createContact() throws IOException {
        Response response = RequestManager.post("Contact", "{\"firstName\" : \"Contacto\", \"lastName\" : \"Example Account\"}");
        this.context.saveData(response.asString());
        response = RequestManager.get("contact/"+context.getValueData("id"));
        context.saveData(response.asString());
    }

    /**
     * AfterHook that deletes a created contact.
     */
    @After(value = "@deleteContact")
    public void deleteAccount() {
        Response response = RequestManager.delete("Contact/".concat(context.getValueData("Id")));
    }
}
