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

    /**
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param name
     */
    public void setSubject(final String name) {
        this.subject = name;
    }

    /**
     *
     * @return relatedWith
     */
    public String getRelatedWith() {
        return relatedWith;
    }

    /**
     *
     * @param related
     */
    public void setRelatedWith(final String related) {
        this.relatedWith = related;
    }

    /**
     *
     * @return relatedValue
     */
    public String getRelatedValue() {
        return this.relatedValue;
    }

    /**
     *
     * @param valName
     */
    public void setRelatedValue(final String valName) {
        this.relatedValue = valName;
    }

    /**
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param newState
     */
    public void setState(final String newState) {
        this.state = newState;
    }

    /**
     *
     * @return dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     *
     * @param newDueDate
     */
    public void setDueDate(final String newDueDate) {
        this.dueDate = newDueDate;
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
