package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String idAccount;
    private String name;
    private String phone;
    private String website;
    private String numberOfEmployees;
    private String industry;
    private String site;

    /**
     * Constructor.
     */
    public Account() {
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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return numberOfEmployees
     */
    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     *
     * @param numberOfEmployees
     */
    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     *
     * @return industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     *
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     *
     * @return site
     */
    public String getSite() {
        return site;
    }

    /**
     *
     * @param site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     *
     * @return idAccount
     */
    public String getIdAccount() {
        return idAccount;
    }

    /**
     *
     * @param idAccount
     */
    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    /**
     * Compose a strategy map.
     * @param accountInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> accountInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(accountInformation.get("Name")));
        strategyMap.put("Phone", () -> setPhone(accountInformation.get("Phone")));
        strategyMap.put("Website", () -> setWebsite(accountInformation.get("Website")));
        strategyMap.put("NumberOfEmployees", () -> setNumberOfEmployees(accountInformation.get("NumberOfEmployees")));
        strategyMap.put("Industry", () -> setIndustry(accountInformation.get("Industry")));
        strategyMap.put("Site", () -> setSite(accountInformation.get("Site")));

        return strategyMap;
    }

    /**
     * Process account's information.
     * @param accountInformation
     */
    public void processInformation(final Map<String, String> accountInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(accountInformation);
        accountInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
