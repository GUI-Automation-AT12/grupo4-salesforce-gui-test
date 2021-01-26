package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

public class Contact {
    private String idContact;
    private String firstname;
    private String lastName;
    private String title;
    private String email;
    private String phone;
    private String accountId;

    /**
     * Constructor.
     */
    public Contact() {
    }

    /**
     *
     * @return first name
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param newFirstName
     */
    public void setFirstname(final String newFirstName) {
        this.firstname = newFirstName;
    }

    /**
     *
     * @return last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param newLastName
     */
    public void setLastName(final String newLastName) {
        this.lastName = newLastName;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return email
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
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return idContact
     */
    public String getIdContact() {
        return idContact;
    }

    /**
     *
     * @param idContact
     */
    public void setIdContact(String idContact) {
        this.idContact = idContact;
    }

    /**
     * Compose a strategy map.
     * @param contactInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> contactInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Firstname", () -> setFirstname(contactInformation.get("Firstname")));
        strategyMap.put("Lastname", () -> setLastName(contactInformation.get("Lastname")));
        strategyMap.put("Title", () -> setTitle(contactInformation.get("Title")));
        strategyMap.put("Email", () -> setEmail(contactInformation.get("Email")));
        strategyMap.put("Phone", () -> setPhone(contactInformation.get("Phone")));
        strategyMap.put("AccountId", () -> setAccountId(contactInformation.get("AccountId")));

        return strategyMap;
    }

    /**
     * Process account's information.
     * @param contactInformation
     */
    public void processInformation(final Map<String, String> contactInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(contactInformation);
        contactInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
