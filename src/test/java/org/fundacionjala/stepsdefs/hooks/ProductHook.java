package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.core.utils.JsonContact;
import org.fundacionjala.salesforce.context.Context;

import java.io.IOException;
import java.util.Map;

public class ProductHook {
    private Context context;

    public ProductHook(final Context context) {
        this.context = context;
    }

    /**
     * Create a Campaign.
     */
    @Before(value = "@createProduct", order = 3)
    public void createProduct() throws IOException {
        Map<String, String> data = JsonContact.getInstance().getDataAsAMap("ProductTest");
        Response response = RequestManager.post("Product2", data.toString());
        context.getProduct().processInformation(data);
        context.getProduct().setIdProduct(response.jsonPath().get("id").toString());
    }

    /**
     * AfterHook that deletes a created Campaign.
     */
    @After(value = "@deleteProduct",  order = 7)
    public void deleteProduct() {
        System.out.println("Product2/" + context.getProduct().getIdProduct());
        RequestManager.delete("Product2/" + context.getProduct().getIdProduct());
    }
}
