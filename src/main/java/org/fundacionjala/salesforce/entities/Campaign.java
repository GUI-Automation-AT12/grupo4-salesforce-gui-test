package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

public class Campaign {
    private String idCampaign;
    private String name;
    private String type;
    private String status;
    private String startDate;
    private String endDate;

    /**
     * Constructor.
     */
    public Campaign() {
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param newType
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param newStatus
     */
    public void setStatus(final String newStatus) {
        this.status = newStatus;
    }

    /**
     *
     * @return start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param newStartDate
     */
    public void setStartDate(final String newStartDate) {
        this.startDate = newStartDate;
    }

    /**
     *
     * @return end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param newEndDate
     */
    public void setEndDate(final String newEndDate) {
        this.endDate = newEndDate;
    }

    /**
     *
     * @return idAccount
     */
    public String getIdCampaign() {
        return idCampaign;
    }

    /**
     *
     * @param id
     */
    public void setIdCampaign(final String id) {
        this.idCampaign = id;
    }

    /**
     * Compose a strategy map.
     * @param campaignInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> campaignInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(campaignInformation.get("Name")));
        strategyMap.put("Type", () -> setType(campaignInformation.get("Type")));
        strategyMap.put("Status", () -> setStatus(campaignInformation.get("Status")));
        strategyMap.put("StartDate", () -> setStartDate(campaignInformation.get("StartDate")));
        strategyMap.put("EndDate", () -> setEndDate(campaignInformation.get("EndDate")));

        return strategyMap;
    }

    /**
     * Process Campaign's information.
     * @param campaignInformation
     */
    public void processInformation(final Map<String, String> campaignInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(campaignInformation);
        campaignInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
