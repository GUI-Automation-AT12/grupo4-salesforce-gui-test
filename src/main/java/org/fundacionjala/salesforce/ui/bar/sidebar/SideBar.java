package org.fundacionjala.salesforce.ui.bar.sidebar;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.entities.Company;


public abstract class SideBar {

    private static SideBar sideBar;

    /**
     * @return the sidebar.
     */
    public static SideBar getInstance() {
        if (sideBar == null) {
            try {
                sideBar = SideBarFactory.getSideBar(APIEnvironment.getInstance().getTypeLayout());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sideBar;
    }

    /**
     * @return CompanyPage.
     */
    public abstract Company goToCompanyInformation();
}
