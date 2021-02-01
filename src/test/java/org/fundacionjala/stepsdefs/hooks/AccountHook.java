package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.utils.JsonAccount;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.entities.Account;

import java.io.IOException;
import java.util.Map;

public class AccountHook {
    private Context context;
    private static String lastScenario;
    private static Account account;

    public AccountHook(final Context context) {
        this.context = context;
    }

    /**
     * Create an account.
     */
    @Before(value = "@createAccount", order = 1)
    public void createAccount() throws IOException {
        Map<String, String> data = JsonAccount.getInstance().getDataAsAMap("AccountTest");
        Response response = RequestManager.post("Account", data.toString());
        context.getAccount().processInformation(data);
        context.getAccount().setIdAccount(response.jsonPath().get("id").toString());
        context.saveData(response.asString());
    }

    @Before(value = "@BeforeScenarioOutline", order = 1)
    public void runBeforeMethod(final Scenario scenario) throws IOException {
        String currentScenario = scenario.getName();
        if (lastScenario == null) {
            System.out.println("****************BEFORE SCENARIO OUTLINE************************\n");
            createAccount();
            account =  new Account();
            account = context.getAccount();
        }
        context.setAccount(account);
        if (currentScenario != lastScenario && lastScenario != null) {
            System.out.println("****************After scenario************************\n");
            WebDriverManager.getInstance().quit();
            deleteAccount();
        }

        lastScenario = currentScenario;
    }


    /**
     * AfterHook that deletes a created Account.
     */
    @After(value = "@deleteAccount", order = 9)
    public void deleteAccount() {
        RequestManager.delete("Account/" + context.getAccount().getIdAccount());
    }
}
