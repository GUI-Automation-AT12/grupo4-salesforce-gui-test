package org.fundacionjala.salesforce.entities;

import org.fundacionjala.core.utils.DateHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * [RH] Opportunity entity.
 */
public class Opportunity {

    private String opportunityName;
    private String accountName;
    private String closeDate;
    private String stage;

    /**
     * [RH] This method returns the opportunity name.
     * @return name
     */
    public String getOpportunityName() {
        return opportunityName;
    }


    /**
     * [RH] This method sets the opportunity name.
     * @param opportunityName
     */
    public void setOpportunityName(String opportunityName) {
        this.opportunityName = opportunityName;
    }

    /**
     * [RH] This method returns the account name.
     * @return account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * [RH] This method sets the account name.
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * [RH] This method returns the close date.
     * @return date
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * [RH] This method sets the close date.
     * @param closeDate
     */
    public void setCloseDate(String closeDate) {
        DateHelper dateHelper = new DateHelper();
        this.closeDate = dateHelper.getDate(closeDate);;
    }

    /**
     * [RH] This method returns the stage.
     * @return date
     */
    public String getStage() {
        return stage;
    }

    /**
     * [RH] This method sets the stage.
     * @param stage
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * Process opportunity's information as a map.
     * @param opportunityInformation
     */
    public void processInformation(final Map<String, String> opportunityInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(opportunityInformation);
        opportunityInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param opportunityInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> opportunityInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Opportunity name", () -> setOpportunityName(opportunityInformation.get("Opportunity name")));
        strategyMap.put("Close date", () -> setCloseDate(opportunityInformation.get("Close date")));
        strategyMap.put("Stage", () -> setStage(opportunityInformation.get("Stage")));
        return strategyMap;
    }
}
