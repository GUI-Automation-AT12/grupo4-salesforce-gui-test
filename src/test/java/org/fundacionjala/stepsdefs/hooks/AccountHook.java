package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.JsonAccount;
import org.fundacionjala.salesforce.context.Context;

import java.io.IOException;
import java.util.Map;

public class AccountHook {
    private Context context;

    public AccountHook(final Context context) {
        this.context = context;
    }

    /**
     * Create an account.
     */
    @Before(value = "@createAccount")
    public void createAccount() throws IOException {
        Map<String, String> data = JsonAccount.getInstance().getDataAsAMap("AccountTest");
        Response response = RequestManager.post("Account", data.toString());
        context.getAccount().processInformation(data);
        context.getAccount().setIdAccount(response.jsonPath().get("id").toString());
        context.saveData(response.asString());
    }

    /**
     * AfterHook that deletes a created Account.
     */
    @After(value = "@deleteAccount")
    public void deleteAccount() {
        RequestManager.delete("Account/" + context.getAccount().getIdAccount());
    }
}
