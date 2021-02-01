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
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
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
     * @param newPhone
     */
    public void setPhone(final String newPhone) {
        this.phone = newPhone;
    }

    /**
     *
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param newWeb
     */
    public void setWebsite(final String newWeb) {
        this.website = newWeb;
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
     * @param employees
     */
    public void setNumberOfEmployees(final String employees) {
        this.numberOfEmployees = employees;
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
     * @param newIndustry
     */
    public void setIndustry(final String newIndustry) {
        this.industry = newIndustry;
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
     * @param newSite
     */
    public void setSite(final String newSite) {
        this.site = newSite;
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
     * @param id
     */
    public void setIdAccount(final String id) {
        this.idAccount = id;
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
