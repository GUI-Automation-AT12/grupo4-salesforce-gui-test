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
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param nameParam
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     *
     * @return lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastNameParam
     */
    public void setLastName(final String lastNameParam) {
        this.lastName = lastNameParam;
    }

    /**
     *
     * @return alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     *
     * @param aliasParam
     */
    public void setAlias(final String aliasParam) {
        this.alias = aliasParam;
    }

    /**
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param emailParam
     */
    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param usernameParam
     */
    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    /**
     *
     * @return nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nicknameParam
     */
    public void setNickname(final String nicknameParam) {
        this.nickname = nicknameParam;
    }

    /**
     *
     * @return position.
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param positionParam
     */
    public void setPosition(final String positionParam) {
        this.position = positionParam;
    }

    /**
     *
     * @return enterprise.
     */
    public String getEnterprise() {
        return enterprise;
    }

    /**
     *
     * @param enterpriseParam
     */
    public void setEnterprise(final String enterpriseParam) {
        this.enterprise = enterpriseParam;
    }

    /**
     *
     * @return department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param departmentParam
     */
    public void setDepartment(final String departmentParam) {
        this.department = departmentParam;
    }

    /**
     *
     * @return division.
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @param divisionParam
     */
    public void setDivision(final String divisionParam) {
        this.division = divisionParam;
    }

    /**
     *
     * @return function.
     */
    public String getFunction() {
        return function;
    }

    /**
     *
     * @param functionParam
     */
    public void setFunction(final String functionParam) {
        this.function = functionParam;
    }

    /**
     *
     * @return user licence.
     */
    public String getUserLicence() {
        return userLicence;
    }

    /**
     *
     * @param userLicenceParam
     */
    public void setUserLicence(final String userLicenceParam) {
        this.userLicence = userLicenceParam;
    }

    /**
     *
     * @return profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     *
     * @param profileParam
     */
    public void setProfile(final String profileParam) {
        this.profile = profileParam;
    }

    /**
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param pwd
     */
    public void setPassword(final String pwd) {
        this.password = PasswordHelper.decrypt(pwd);
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
        strategyMap.put("Name", () -> setName(userInformation.get("Name")));
        strategyMap.put("LastName", () -> setLastName(userInformation.get("LastName")));
        strategyMap.put("Alias", () -> setAlias(userInformation.get("Alias")));
        strategyMap.put("Email", () -> setEmail(userInformation.get("Email")));
        strategyMap.put("Username", () -> setUsername(userInformation.get("Username")));
        strategyMap.put("Nickname", () -> setNickname(userInformation.get("Nickname")));
        strategyMap.put("Position", () -> setPosition(userInformation.get("Position")));
        strategyMap.put("Enterprise", () -> setEnterprise(userInformation.get("Enterprise")));
        strategyMap.put("Department", () -> setDepartment(userInformation.get("Department")));
        strategyMap.put("Division", () -> setDivision(userInformation.get("Division")));
        strategyMap.put("Function", () -> setFunction(userInformation.get("Function")));
        strategyMap.put("UserLicence", () -> setUserLicence(userInformation.get("UserLicence")));
        strategyMap.put("Profile", () -> setProfile(userInformation.get("Profile")));
        strategyMap.put("Password", () -> setPassword(userInformation.get("Password")));
        return strategyMap;
    }

}
