package org.fundacionjala.salesforce.ui.pages.company.companyprofile;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * [JS]
 */
public class CompanyProfilePage extends BasePage {

    @FindBy(css = "#bodyCell > div.bTask > div > div.pbBody > table > tbody > tr:nth-child(1) > td:nth-child(1) > a")
    private WebElement linkUpdateCompanyInformation;


    private void clickLinkUpdate() {
        WebDriverHelper.clickElement(linkUpdateCompanyInformation);
    }

    /**
     *
     * @return companyInformation
     */
    public CompanyInformation getCompanyInformation() {
        clickLinkUpdate();
        return new CompanyInformation();
    }

}
