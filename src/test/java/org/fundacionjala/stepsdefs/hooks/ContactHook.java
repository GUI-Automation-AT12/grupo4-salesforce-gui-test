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
    @Before(value = "@createContact")
    public void createContact() throws IOException {
        Map<String, String> data = JsonContact.getInstance().getDataAsAMap("ContactTest");
        data.put("AccountId",context.getAccount().getIdAccount());
        Response response = RequestManager.post("Contact", data.toString());
        context.getContact().processInformation(data);
        context.getContact().setIdContact(response.jsonPath().get("id").toString());
        context.saveData(response.asString());
    }

    /**
     * AfterHook that deletes a created contact.
     */
    @After(value = "@deleteContact")
    public void deleteContact() {
        RequestManager.delete("Contact/" + context.getContact().getIdContact());
    }
}
