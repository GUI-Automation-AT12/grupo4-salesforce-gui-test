package org.fundacionjala.salesforce.entities;

import org.fundacionjala.core.utils.DateHelper;

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
    private String selectName;
    private String nameUser;
    private String SelectRelatedTo;
    private String relatedTo;
    private DateHelper dateHelper = new DateHelper();

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
        this.startDate = dateHelper.getDate(newStartDate);;
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
        this.endDate = dateHelper.getDate(newEndDate);
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
        this.startTime = dateHelper.getDate(newStartTime);
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
        this.endTime = dateHelper.getDate(newEndTime);
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
    public String getRelatedTo() {
        return relatedTo;
    }

    /**
     *
     * @param newNameTypeApp
     */
    public void setRelatedTo(String newNameTypeApp) {
        this.relatedTo = newNameTypeApp;
    }

    /**
     *
     * @return selectName
     */
    public String getSelectName() {
        return selectName;
    }

    /**
     *
     * @param newSelectName
     */
    public void setSelectName(String newSelectName) {
        this.selectName = newSelectName;
    }

    /**
     *
     * @return SelectRelatedTo
     */
    public String getSelectRelatedTo() {
        return SelectRelatedTo;
    }

    /**
     *
     * @param newSelectRelatedTo
     */
    public void setSelectRelatedTo(String newSelectRelatedTo) {
        SelectRelatedTo = newSelectRelatedTo;
    }

    /**
     * Compose a strategy map.
     * @param eventInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> eventInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> setSubject(eventInformation.get("Subject")));
        strategyMap.put("Location", () -> setLocation(eventInformation.get("Location")));
        strategyMap.put("StartDate", () -> setStartDate(eventInformation.get("StartDate")));
        strategyMap.put("StartTime", () -> setStartTime(eventInformation.get("StartTime")));
        strategyMap.put("EndDate", () -> setEndDate(eventInformation.get("EndDate")));
        strategyMap.put("EndTime", () -> setEndTime(eventInformation.get("EndTime")));
        strategyMap.put("Select Name", () -> setSelectName(eventInformation.get("Select Name")));
        strategyMap.put("Name", () -> setName(eventInformation.get("Name")));
        strategyMap.put("Select RelatedTo", () -> setSelectRelatedTo(eventInformation.get("Select RelatedTo")));
        strategyMap.put("RelatedTo", () -> setRelatedTo(eventInformation.get("RelatedTo")));

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
