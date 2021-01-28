package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private String idEvent;
    private String name;
    private String subject;
    private String location;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String nameUser;
    private String nameApp;

    /**
     * Constructor.
     */
    public Event() {
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
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param newType
     */
    public void setSubject(final String newType) {
        this.subject = newType;
    }

    /**
     *
     * @return status
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param newStatus
     */
    public void setLocation(final String newStatus) {
        this.location = newStatus;
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
    public String getIdEvent() {
        return idEvent;
    }

    /**
     *
     * @param id
     */
    public void setIdEvent(final String id) {
        this.idEvent = id;
    }

    /**
     *
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     *
     * @param newStartTime
     */
    public void setStartTime(String newStartTime) {
        this.startTime = newStartTime;
    }

    /**
     *
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     *
     * @param newEndTime
     */
    public void setEndTime(String newEndTime) {
        this.endTime = newEndTime;
    }

    /**
     *
     * @return nameTypeUser
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     *
     * @param newNameTypeUser
     */
    public void setNameUser(String newNameTypeUser) {
        this.nameUser = newNameTypeUser;
    }

    /**
     *
     * @return nameTypeApp
     */
    public String getNameApp() {
        return nameApp;
    }

    /**
     *
     * @param newNameTypeApp
     */
    public void setNameApp(String newNameTypeApp) {
        this.nameApp = newNameTypeApp;
    }

    /**
     * Compose a strategy map.
     * @param eventInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> eventInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(eventInformation.get("Name")));
        strategyMap.put("Subject", () -> setSubject(eventInformation.get("Subject")));
        strategyMap.put("Location", () -> setLocation(eventInformation.get("Location")));
        strategyMap.put("StartDate", () -> setStartDate(eventInformation.get("StartDate")));
        strategyMap.put("StartTime", () -> setStartDate(eventInformation.get("StartTime")));
        strategyMap.put("EndDate", () -> setEndDate(eventInformation.get("EndDate")));
        strategyMap.put("EndTime", () -> setEndDate(eventInformation.get("EndTime")));
        strategyMap.put("NameUser", () -> setEndDate(eventInformation.get("NameUser")));
        strategyMap.put("NameApp", () -> setEndDate(eventInformation.get("NameApp")));

        return strategyMap;
    }

    /**
     * Process Campaign's information.
     * @param eventInformation
     */
    public void processInformation(final Map<String, String> eventInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(eventInformation);
        eventInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
