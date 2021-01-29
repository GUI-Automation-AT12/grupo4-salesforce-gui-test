package org.fundacionjala.salesforce.ui.bar.navbar;


import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.ComponentFactory;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;
import org.fundacionjala.salesforce.ui.pages.BasePage;

public abstract class NavBar extends BasePage {

    private static NavBar navBar;

    /**
     *
     * @return navbar instantiated.
     */
    public static NavBar getInstance() {
        if (navBar == null) {
            try {
                navBar = ComponentFactory.getNavBar(APIEnvironment.getInstance().getTypeLayout());
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
    public abstract SideBar goToConfigurations() throws Exception;
}
