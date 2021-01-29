package org.fundacionjala.stepsdefs.company;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.entities.Company;
import org.fundacionjala.salesforce.ui.ComponentFactory;
import org.fundacionjala.salesforce.ui.bar.navbar.NavBar;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;
import org.fundacionjala.salesforce.ui.pages.company.companyform.CompanyForm;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;
import org.testng.asserts.SoftAssert;

import java.util.Map;
/**
 * [JS]
 */
public class CompanyStep {
    CompanyInformation companyInformation;
    NavBar navBar;
    SideBar sideBar;
    CompanyForm companyForm;
    Company company;
    Map<String, String> companyInformationMap;
    Context context;

    public CompanyStep(final Context context) {
        this.context = context;
    }

    @Given("I navigates to Profile Company pages")
    public void navigateToProfileCompanyPage() throws Exception {
        navBar = ComponentFactory.getNavBar(APIEnvironment.getInstance().getTypeLayout());
        sideBar = navBar.goToConfigurations();
    }

    @When("I navigate to Update Company Information pages")
    public void navigateToUpdateCompanyInformationPage() throws Exception {
        companyInformation = sideBar.goToCompanyInformation();
        companyForm = companyInformation.goToTheForm(context.getCompany());
    }

    @And("I edit the company information with following information")
    public void editTheCompanyInformationWithFollowingInformation(final Map<String, String> companyInformationn) {
        company = new Company();
        companyInformationMap = company.processInformation(companyInformationn);
        context.setEditedFieldsCompany(companyInformationn.keySet());
        context.getCompany().add(company);

        companyInformation = companyForm.editCompanyInformation(companyInformationn.keySet(), company);

    }

    @Then("The company information updated in the company section")
    public void updateInTheCompanySection() {
        Map<String, String> actualCompanyInfo = companyInformation.getCompanyInformation(companyInformationMap.keySet());
        Map<String, String> expectedCompanyInfo = company.composeStrategyGetterMap();
        SoftAssert softAssert = new SoftAssert();
        actualCompanyInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedCompanyInfo.get(field),
                    "The " + field + " from Company Page does not match with the " + field + " edited previously.");
        });
        softAssert.assertAll();
    }
}
