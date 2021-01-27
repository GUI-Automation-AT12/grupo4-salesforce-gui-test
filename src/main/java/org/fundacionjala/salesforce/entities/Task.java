package org.fundacionjala.salesforce.entities;

import org.fundacionjala.core.utils.DateHelper;

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

    public void setDueDate(String dueDate) {
        DateHelper date = new DateHelper();
        this.dueDate = date.getDate(dueDate);
    }

    /**
     * Process task's information as a map.
     * @param taskInformation
     */
    public void processInformation(final Map<String, String> taskInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(taskInformation);
        taskInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param taskInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> taskInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> setSubject(taskInformation.get("Subject")));
        strategyMap.put("Related with", () -> setRelatedWith(taskInformation.get("Related with")));
        strategyMap.put("Related value", () -> setRelatedValue(taskInformation.get("Related value")));
        strategyMap.put("Status", () -> setState(taskInformation.get("Status")));
        strategyMap.put("Expiration date", () -> setDueDate(taskInformation.get("Expiration date")));
        return strategyMap;
    }
}
