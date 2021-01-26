package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * [RH] Task entity class.
 */
public class Task {

    private String subject;
    private String relatedWith;
    private String relatedValue;
    private String state;
    private String dueDate;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String name) {
        this.subject = name;
    }

    public String getRelatedWith() {
        return relatedWith;
    }

    public void setRelatedWith(String relatedWith) {
        this.relatedWith = relatedWith;
    }

    public String getRelatedValue() {
        return this.relatedValue;
    }

    public void setRelatedValue(String valueName) {
        this.relatedValue = valueName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Process user's information as a map.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param userInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> setSubject(userInformation.get("Subject")));
        strategyMap.put("Related with", () -> setRelatedWith(userInformation.get("Related with")));
        strategyMap.put("Related value ", () -> setRelatedValue(userInformation.get("Related value ")));
        strategyMap.put("State", () -> setState(userInformation.get("State")));
        strategyMap.put("Expiration date", () -> setDueDate(userInformation.get("Expiration date")));
        return strategyMap;
    }
}
