package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class Company {
  private String organizationName;
  private String primaryContact;
  private Set<String> editedFields;
  static final String ORGANIZATION = "Name of organization";


    /**
     *
     * @param edited
     */
    public void setEditedFields(final Set<String> edited) {
        this.editedFields = edited;
    }

    /**
     *
     * @return the organization name.
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     *
     * @param organizationNamee
     */
    public void setOrganizationName(final String organizationNamee) {
        this.organizationName = organizationNamee;
    }

    /**
     *
     * @return primary contact
     */
    public String getPrimaryContact() {
        return primaryContact;
    }

    /**
     *
     * @param primaryContactt
     */
    public void setPrimaryContact(final String primaryContactt) {
        this.primaryContact = primaryContactt;
    }

    /**
     *
     * @return the division.
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @param divisionn
     */
    public void setDivision(final String divisionn) {
        division = divisionn;
    }

    private String division;


    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> companyInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ORGANIZATION, () -> setOrganizationName(companyInformation.get("Name of organization")));
        strategyMap.put("Primary contact", () -> setPrimaryContact(companyInformation.get("Primary contact")));
        strategyMap.put("Division", () -> setDivision(companyInformation.get("Division")));
        return strategyMap;
    }

    /**
     * Process all information stored for a User as a map.
     * @param companyInformation
     */
    public void processInformation(final Map<String, String> companyInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(companyInformation);
        companyInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("Name of organization", () -> getOrganizationName());
        strategyMap.put("Primary contact", () -> getPrimaryContact());
        strategyMap.put("Division", () -> getDivision());
        return strategyMap;
    }
}
