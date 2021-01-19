package org.fundacionjala.salesforce.entities;

public class Contact {
    private String firstname;
    private String lastName;

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
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
}
