package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.fundacionjala.salesforce.context.Context;

public class APIStepdefs {

    private Context context;

    public APIStepdefs(final Context context) {
        this.context = context;
    }

    @Given("I created a valid campaign")
    public void iCreatedAValidCampaign() {
    }

}
