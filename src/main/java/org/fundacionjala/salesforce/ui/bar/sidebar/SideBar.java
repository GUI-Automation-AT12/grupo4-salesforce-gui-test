package org.fundacionjala.salesforce.ui.bar.sidebar;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.ComponentFactory;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.company.companyinformation.CompanyInformation;


public abstract class SideBar extends BasePage {

    private static SideBar sideBar;

    /**
     * @return the sidebar.
     */
    public static SideBar getInstance() {
        if (sideBar == null) {
            try {
                sideBar = ComponentFactory.getSideBar(APIEnvironment.getInstance().getTypeLayout());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sideBar;
    }

    /**
     * @return CompanyPage.
     */
    public abstract CompanyInformation goToCompanyInformation() throws Exception;
}

