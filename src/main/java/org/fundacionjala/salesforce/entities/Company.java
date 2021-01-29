package org.fundacionjala.salesforce.entities;

import org.fundacionjala.salesforce.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.ALIAS;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.ORGANIZATION;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.CELPHONE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.DIVISION;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.LOCALE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.CITY;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.CURRENCY_LOCALE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.COUNTRY;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.FAX;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.STATE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.STREET;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.STRING_TO_CHANGE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.PRIMARY_CONTACT;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.ZIP;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.LANGUAGE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.TIME_ZONE;

public class Company {
    //fields
    private String organizationName;
    private String primaryContact;
    private String division;
    private String phone;
    private String fax;
    private String city;
    private String street;
    private String stateProvince;
    private String zipPostalCode;
    private String country;
    private String defaultLocale;
    private String defaultLanguage;
    private String defaultTimeZone;
    private String currencyLocale;
    private String alias;

    private Set<String> editedFields;

    /**
     * @return the alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias
     */
    public void setAlias(final String alias) {
        this.alias = alias;
    }


    /**
     * @param edited
     */
    public void setEditedFields(final Set<String> edited) {
        this.editedFields = edited;
    }

    /**
     * @return the organization name.
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationNamee
     */
    public void setOrganizationName(final String organizationNamee) {
        if (organizationNamee != null) {
            organizationName = organizationNamee.replaceAll(STRING_TO_CHANGE, IdGenerator.getUniqueId());
        } else {
            organizationName = " ";
        }
    }

    /**
     * @return primary contact
     */
    public String getPrimaryContact() {
        return primaryContact;
    }

    /**
     * @param primaryContactt
     */
    public void setPrimaryContact(final String primaryContactt) {
        if (primaryContactt != null) {
            primaryContact = primaryContactt.replaceAll(STRING_TO_CHANGE, IdGenerator.getUniqueId());
        } else {
            primaryContact = " ";
        }
    }

    /**
     * @return the division.
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param divisionn
     */
    public void setDivision(final String divisionn) {
        if (divisionn != null) {
            division = divisionn.replaceAll(STRING_TO_CHANGE, IdGenerator.getUniqueId());
        } else {
            division = " ";
        }
    }

    /**
     * @return the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone number.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return the fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     */
    public void setFax(final String fax) {
        this.fax = fax;
    }

    /**
     * @return the city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the street.
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street
     */
    public void setStreet(final String street) {
        this.street = street;
    }

    /**
     * @return Province
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * @param stateProvince
     */
    public void setStateProvince(final String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * @return Zip code.
     */
    public String getZipPostalCode() {
        return zipPostalCode;
    }

    /**
     * @param zipPostalCode
     */
    public void setZipPostalCode(final String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    /**
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return locale.
     */
    public String getDefaultLocale() {
        return defaultLocale;
    }

    /**
     * @param defaultLocale
     */
    public void setDefaultLocale(final String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * @return Language.
     */
    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * @param defaultLanguage
     */
    public void setDefaultLanguage(final String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    /**
     * @return time zone.
     */
    public String getDefaultTimeZone() {
        return defaultTimeZone;
    }

    /**
     * @param defaultTimeZone
     */
    public void setDefaultTimeZone(final String defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    /**
     * @return locale
     */
    public String getCurrencyLocale() {
        return currencyLocale;
    }

    /**
     * @param currencyLocale
     */
    public void setCurrencyLocale(final String currencyLocale) {
        this.currencyLocale = currencyLocale;
    }

    /**
     * @return set.
     */
    public Set<String> getEditedFields() {
        return editedFields;
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> companyInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ORGANIZATION, () -> setOrganizationName(companyInformation.get(ORGANIZATION)));
        strategyMap.put(PRIMARY_CONTACT, () -> setPrimaryContact(companyInformation.get(PRIMARY_CONTACT)));
        strategyMap.put(ALIAS, () -> setAlias(companyInformation.get(ALIAS)));
        strategyMap.put(DIVISION, () -> setDivision(companyInformation.get(DIVISION)));
        strategyMap.put(CELPHONE, () -> setPhone(companyInformation.get(CELPHONE)));
        strategyMap.put(FAX, () -> setFax(companyInformation.get(FAX)));
        strategyMap.put(STREET, () -> setStreet(companyInformation.get(STREET)));
        strategyMap.put(CITY, () -> setCity(companyInformation.get(CITY)));
        strategyMap.put(STATE, () -> setStateProvince(companyInformation.get(STATE)));
        strategyMap.put(ZIP, () -> setZipPostalCode(companyInformation.get(ZIP)));
        strategyMap.put(COUNTRY, () -> setCountry(companyInformation.get(COUNTRY)));
        strategyMap.put(LOCALE, () -> setDefaultLocale(companyInformation.get(LOCALE)));
        strategyMap.put(LANGUAGE, () -> setDefaultLanguage(companyInformation.get(LANGUAGE)));
        strategyMap.put(TIME_ZONE, () -> setDefaultTimeZone(companyInformation.get(TIME_ZONE)));
        strategyMap.put(CURRENCY_LOCALE, () -> setCurrencyLocale(companyInformation.get(CURRENCY_LOCALE)));
        return strategyMap;
    }

    /**
     * Process all information stored for a User as a map.
     *
     * @param companyInformation
     * @return  processInformation.
     */
    public Map<String, String> processInformation(final Map<String, String> companyInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(companyInformation);
        companyInformation.keySet().forEach(key -> strategyMap.get(key).run());
        return companyInformation;
    }

    /**
     *
     * @return Map composeGetter.
     */
    public Map<String, String> composeStrategyGetterMap() {
        Map strategyMap = new HashMap<String, String>();
        strategyMap.put(ORGANIZATION, getOrganizationName());
        strategyMap.put(PRIMARY_CONTACT, getPrimaryContact());
        strategyMap.put(DIVISION, getDivision());
        strategyMap.put(CELPHONE, getPhone());
        strategyMap.put(FAX, getFax());
        strategyMap.put(STREET, getStreet());
        strategyMap.put(CITY, getStreet());
        strategyMap.put(STATE, getStateProvince());
        strategyMap.put(ZIP, getZipPostalCode());
        strategyMap.put(COUNTRY, getCountry());
        strategyMap.put(LOCALE, getDefaultLocale());
        strategyMap.put(LANGUAGE, getDefaultLanguage());
        strategyMap.put(TIME_ZONE, getDefaultTimeZone());
        strategyMap.put(CURRENCY_LOCALE, getCurrencyLocale());
        return strategyMap;
    }
}
