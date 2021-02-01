package org.fundacionjala.salesforce.ui.bar.sidebar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarLighting extends SideBar {
    @FindBy(css = "#split-left > div > div > div > ul > li:nth-child(23) > div > a")
    private WebElement dropDownCompanyProfile;

    @FindBy(css = "#split-left > div > div > div > ul > li:nth-child(23) > ul > li:nth-child(2) > div > a")
    private WebElement linkCompanyInformation;

    private void clickDropdown() {
        WebDriverHelper.clickElement(dropDownCompanyProfile);
    }

    private void clickLinkCompanyInformation() {
        WebDriverHelper.clickElement(linkCompanyInformation);
    }
    /**
     * [JS].
     * @return
     */
    @Override
    public CompanyInformation goToCompanyInformation() throws Exception {
        TransporterPage.navigateToPage("CompanyProfile");
        return new CompanyInformation();
    }
}

