package org.fundacionjala.stepsdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.fundacionjala.core.utils.JsonCompany;
import org.fundacionjala.salesforce.context.Context;
import org.fundacionjala.salesforce.entities.Company;
import org.fundacionjala.salesforce.ui.pages.company.companyform.CompanyForm;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;

import java.io.IOException;
import java.util.Map;
/**
 * [JS]
 */
public class CompanyHook {

    private Context context;
    private CompanyInformation companyInformation;
    private CompanyForm companyForm;
    private Company company;
    public CompanyHook(final Context context) {
        this.context = context;
    }

    /**
     * BeforeHook that Creates a contact.
     */
    @Before(value = "@LoadDefaultContact")
    public void loadJson() throws IOException {
        Map<String, String> data = JsonCompany.getInstance().getDataAsAMap("CompanyTest");
        company = new Company();
        company.processInformation(data);
        context.getCompany().add(company);
    }

    /**
     * AfterHook that deletes a created contact.
     */
    @After(value = "@RestoreInformation")
    public void restoreCompanyInformation() {
        for (Company value: context.getCompany()) {
            if (value.getAlias().equals("DataToRestore")) {
                company = value;
                break;
            }
        }
        companyInformation = new CompanyInformation();
        companyInformation.goToTheForm(context.getCompany()).restoreInformation(context.getEditedFieldsCompany(),company);

    }
}
