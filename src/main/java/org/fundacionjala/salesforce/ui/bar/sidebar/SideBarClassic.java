package org.fundacionjala.salesforce.ui.bar.sidebar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarClassic extends SideBar {
    @FindBy(id = "CompanyProfile_icon")
    private WebElement dropDown;
    @FindBy(id = "CompanyProfileInfo_font")
    private WebElement linkProfileInformation;


    private void clickDropDownCompanyProfile() {
        WebDriverHelper.clickElement(dropDown);
    }

    private void clickCompanyProfileLink() {
        WebDriverHelper.clickElement(linkProfileInformation);
    }

    /**
     * returns a companyInformation Page.
     * @return
     */
    @Override
    public CompanyInformation goToCompanyInformation() {
        clickDropDownCompanyProfile();
        clickCompanyProfileLink();
        return new CompanyInformation();
    }
}
