package org.fundacionjala.stepsdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.utils.setup.MainSetup;

public class APIStepdefs {

    private Context context;

    public APIStepdefs(final Context context) {
        this.context = context;
    }

    @Given("I created a valid campaign")
    public void iCreatedAValidCampaign() {
        MainSetup setupHelper =  new MainSetup();
        setupHelper.setupCampaigns();
    }

}
