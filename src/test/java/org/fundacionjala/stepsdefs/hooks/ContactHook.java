package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.JsonContact;
import org.fundacionjala.salesforce.context.Context;
import java.io.IOException;
import java.util.Map;

public class ContactHook {
    private Context context;

    public ContactHook(final Context context) {
        this.context = context;
    }

    /**
     * BeforeHook that Creates a contact.
     */
    @Before(value = "@createContactRelatedToAccount", order = 1)
    public void createContactRelatedAccount() throws IOException {
        Map<String, String> data = JsonContact.getInstance().getDataAsAMap("ContactTest");
        data.put("AccountId",context.getAccount().getIdAccount());
        Response response = RequestManager.post("Contact", data.toString());
        context.getContact().processInformation(data);
        context.getContact().setIdContact(response.jsonPath().get("id").toString());
        context.saveData(response.asString());
    }

    @Before(value = "@createContact", order = 2)
    public void createContact() throws IOException {
        Map<String, String> data = JsonContact.getInstance().getDataAsAMap("Contact");
        Response response = RequestManager.post("Contact", data.toString());
        context.getContact().setIdContact(response.jsonPath().get("id").toString());
        context.getContact().processInformation(data);
        response = RequestManager.get("contact/"+context.getContact().getIdContact());
        context.saveData(response.asString());
    }

    @Before(value = "@setup")
    public void setup() throws IOException {
    }

    /**
     * AfterHook that deletes a created contact.
     */
    @After(value = "@deleteContact", order = 8)
    public void deleteContact() {
        RequestManager.delete("Contact/" + context.getContact().getIdContact());
    }
}
