package org.fundacionjala.salesforce.entities;

import org.fundacionjala.core.utils.PasswordHelper;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private String lastName;
    private String alias;
    private String email;
    private String username;
    private String nickname;
    private String position;
    private String enterprise;
    private String department;
    private String division;
    private String function;
    private String userLicence;
    private String profile;
    private String password;

    /**
     *
     * @return
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
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAlias() {
        return alias;
    }

    /**
     *
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     *
     * @return
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     *
     * @param enterprise
     */
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     *
     * @return
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @param division
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     *
     * @return
     */
    public String getFunction() {
        return function;
    }

    /**
     *
     * @param function
     */
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     *
     * @return
     */
    public String getUserLicence() {
        return userLicence;
    }

    /**
     *
     * @param userLicence
     */
    public void setUserLicence(String userLicence) {
        this.userLicence = userLicence;
    }

    /**
     *
     * @return
     */
    public String getProfile() {
        return profile;
    }

    /**
     *
     * @param profile
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Process user's information as a map.
     * @param UserInformation
     */
    public void processInformation(final Map<String, String> UserInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(UserInformation);
        UserInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param UserInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> UserInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(UserInformation.get("Name")));
        strategyMap.put("LastName", () -> setLastName(UserInformation.get("LastName")));
        strategyMap.put("Alias", () -> setAlias(UserInformation.get("Alias")));
        strategyMap.put("Email", () -> setEmail(UserInformation.get("Email")));
        strategyMap.put("Username", () -> setUsername(UserInformation.get("Username")));
        strategyMap.put("Nickname", () -> setNickname(UserInformation.get("Nickname")));
        strategyMap.put("Position", () -> setPosition(UserInformation.get("Position")));
        strategyMap.put("Enterprise", () -> setEnterprise(UserInformation.get("Enterprise")));
        strategyMap.put("Department", () -> setDepartment(UserInformation.get("Department")));
        strategyMap.put("Division", () -> setDivision(UserInformation.get("Division")));
        strategyMap.put("Function", () -> setFunction(UserInformation.get("Function")));
        strategyMap.put("UserLicence", () -> setUserLicence(UserInformation.get("UserLicence")));
        strategyMap.put("Profile", () -> setProfile(UserInformation.get("Profile")));
        return strategyMap;
    }

}
