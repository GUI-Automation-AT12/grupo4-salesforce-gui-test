package org.fundacionjala.salesforce.ui.pages.company.companyform;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.entities.Company;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Set;

import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.LIGHTNING;
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
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.PRIMARY_CONTACT;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.ZIP;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.LANGUAGE;
import static org.fundacionjala.salesforce.entities.constants.ContantsCompany.TIME_ZONE;

/**
 * [JS]
 */
public class CompanyForm extends BasePage {


    @FindBy(xpath = "//div//iframe[contains(@title,'Edit Organization')]")
    private WebElement iframeXpath;

    @FindBy(id = "Name")
    private WebElement txtOrganizationName;
    @FindBy(id = "PrimaryContact")
    private WebElement txtPrimaryContact;
    @FindBy(id = "Division")
    private WebElement txtDivision;
    @FindBy(id = "Phone")
    private WebElement txtPhone;
    @FindBy(id = "Fax")
    private WebElement txtFax;
    @FindBy(id = "Addressstreet")
    private WebElement txtStreet;
    @FindBy(id = "Addresscity")
    private WebElement txtCity;
    @FindBy(id = "Addressstate")
    private WebElement txtState;
    @FindBy(id = "Addresszip")
    private WebElement txtZip;
    @FindBy(id = "Addresscountry")
    private WebElement txtCountry;
    @FindBy(id = "DefaultLocaleSidKey")
    private WebElement comboBoxLocale;
    @FindBy(id = "LanguageLocaleKey")
    private WebElement comboBoxLanguage;
    @FindBy(id = "TimeZoneSidKey")
    private WebElement comboBoxTimeZone;
    @FindBy(id = "DefaultCurrencyIsoCode")
    private WebElement comboBoxCurrency;
    @FindBy(xpath = "//input[@name='save']")
    private WebElement buttonSave;

    /**
     *
     */
    public CompanyForm() {
    }


    private Set<String> toRestore;

    /**
     * @param newName
     */
    private void fillOrganizationNameTextBox(final String newName) {
        WebDriverHelper.setElement(txtOrganizationName, newName);
    }

    /**
     * @param primaryContact
     */
    private void fillPrimaryContactTextBox(final String primaryContact) {
        WebDriverHelper.setElement(txtPrimaryContact, primaryContact);
    }

    private void fillDivisionBox(final String division) {
        WebDriverHelper.setElement(txtDivision, division);
    }

    private void fillPhoneTextBox(final String phone) {
        WebDriverHelper.setElement(txtPhone, phone);
    }

    private void fillFaxTextBox(final String fax) {
        WebDriverHelper.setElement(txtFax, fax);
    }

    private void fillStreetTextBox(final String street) {
        WebDriverHelper.setElement(txtStreet, street);
    }

    private void fillCityTextBox(final String city) {
        WebDriverHelper.setElement(txtCity, city);
    }

    private void fillStateTextBox(final String state) {
        WebDriverHelper.setElement(txtState, state);
    }

    private void fillZipTextBox(final String zip) {
        WebDriverHelper.setElement(txtZip, zip);
    }

    private void fillCountryTextBox(final String country) {
        WebDriverHelper.setElement(txtCountry, country);
    }

    private void selectLocaleComboBox(final String locale) {
        WebDriverHelper.selectItemByValue(comboBoxLocale, locale);
    }

    private void selectLanguageComboBox(final String language) {
        WebDriverHelper.selectItemByValue(comboBoxLanguage, language);
    }

    private void selectTimeZoneComboBox(final String timeZone) {
        WebDriverHelper.selectItemByValue(comboBoxTimeZone, timeZone);
    }

    private void selectCurrencyComboBox(final String currency) {
        WebDriverHelper.selectItemByValue(comboBoxCurrency, currency);
    }

    private void clickSaveBtn() {
        goToTheIframe(APIEnvironment.getInstance().getTypeLayout());
        WebDriverHelper.clickElement(buttonSave);
    }

    private HashMap<String, Runnable> composeMapStrategy(final Company company) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put(ORGANIZATION, () -> fillOrganizationNameTextBox(company.getOrganizationName()));
        strategyMap.put(PRIMARY_CONTACT, () -> fillPrimaryContactTextBox(company.getPrimaryContact()));
        strategyMap.put(DIVISION, () -> fillDivisionBox(company.getDivision()));
        strategyMap.put(CELPHONE, () -> fillPhoneTextBox(company.getPhone()));
        strategyMap.put(FAX, () -> fillFaxTextBox(company.getFax()));
        strategyMap.put(STREET, () -> fillStreetTextBox(company.getStreet()));
        strategyMap.put(CITY, () -> fillCityTextBox(company.getCity()));
        strategyMap.put(STATE, () -> fillStateTextBox(company.getStateProvince()));
        strategyMap.put(ZIP, () -> fillZipTextBox(company.getZipPostalCode()));
        strategyMap.put(COUNTRY, () -> fillCountryTextBox(company.getCountry()));
        strategyMap.put(LOCALE, () -> selectLocaleComboBox(company.getDefaultLocale()));
        strategyMap.put(LANGUAGE, () -> selectLanguageComboBox(company.getDefaultLanguage()));
        strategyMap.put(TIME_ZONE, () -> selectTimeZoneComboBox(company.getDefaultTimeZone()));
        strategyMap.put(CURRENCY_LOCALE, () -> selectCurrencyComboBox(company.getCurrencyLocale()));
        return strategyMap;
    }

    private void setInformationToEdit(final Set<String> formFields, final Company company) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(company);
        goToTheIframe(APIEnvironment.getInstance().getTypeLayout());
        formFields.forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Edits information of a company  from GUI.
     *
     * @param formFields fields to be edited
     * @param company    company to be edited
     * @return companyInformation
     */
    public CompanyInformation editCompanyInformation(final Set<String> formFields, final Company company) {
        setInformationToEdit(formFields, company);
        clickSaveBtn();
        return new CompanyInformation();
    }

    /**
     * @param formFields
     * @param company
     */
    public void restoreInformation(final Set<String> formFields, final Company company) {
        setInformationToEdit(formFields, company);
        clickSaveBtn();
    }

    /**
     * @param typeLayout
     */
    private void goToTheIframe(final String typeLayout) {
        if (typeLayout.equals(LIGHTNING)) {
            WebDriverHelper.frameToBeAvailableAndSwitchToIt(iframeXpath);
        }
    }
}
