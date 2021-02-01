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
     * @param newTitle
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
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
     * @param newEmail
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
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
     * @return accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     *
     * @param id
     */
    public void setAccountId(final String id) {
        this.accountId = id;
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
     * @param id
     */
    public void setIdContact(final String id) {
        this.idContact = id;
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
