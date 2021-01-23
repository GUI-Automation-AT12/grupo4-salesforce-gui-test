package org.fundacionjala.salesforce.ui.bar.navbar;


import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;

public abstract class NavBar {

    private static NavBar navBar;

    /**
     *
     * @return navbar instantiated.
     */
    public static NavBar getInstance() {
        if (navBar == null) {
            try {
                navBar = NavBarFactory.getNavBar(APIEnvironment.getInstance().getTypeLayout());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return navBar;
    }

    /**
     *
     * @return the sidebar.
     */
    public abstract SideBar goToConfigurations();
}
