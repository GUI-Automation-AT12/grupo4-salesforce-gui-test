package org.fundacionjala.core.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.json.JSONObject;
import java.util.List;

/**
 * [RH] setup reader class.
 */
public class SetupReader extends ExcelReader{

    private static String path = "src/main/resources/setup/initialSetup.xlsx";
    private Sheet contactSheet;
    private Sheet campaignSheet;
    private Sheet opportunitySheet;
    private Sheet caseSheet;
    public SetupReader() {
        super(path);
    }

    /**
     * [RH] Get contacts sheet from the excel file.
     */
    private void setContactSheet() {
        contactSheet = searchSheet("Contacts");
    }

    /**
     * [RH] Get opportunities sheet from the excel file.
     */
    private void setOpportunitiesSheet() {
        opportunitySheet = searchSheet("Opportunities");
    }

    /**
     * [RH] Get campaigns sheet from the excel file.
     */
    private void setCampaignsSheet() {
        campaignSheet = searchSheet("Campaigns");
    }

    /**
     * [RH] Get cases sheet from the excel file.
     */
    private void setCasesSheet() {
        caseSheet = searchSheet("Cases");
    }

    /**
     * [RH] this method returns the contact sheet converted to json.
     * @return list
     */
    public List<JSONObject> getConvertedContactSheet() {
        setContactSheet();
        return convertToJson(contactSheet);
    }

    /**
     * [RH] this method returns the campaign sheet converted to json.
     * @return list
     */
    public List<JSONObject> getConvertedCampaignSheet() {
        setCampaignsSheet();
        return convertToJson(campaignSheet);
    }

    /**
     * [RH] this method returns the opportunity sheet converted to json.
     * @return list
     */
    public List<JSONObject> getConvertedOpportunitySheet() {
        setOpportunitiesSheet();
        return convertToJson(opportunitySheet);
    }

    /**
     * [RH] this method returns the case sheet converted to json.
     * @return list
     */
    public List<JSONObject> getConvertedCaseSheet() {
        setCasesSheet();
        return convertToJson(caseSheet);
    }


}
