package org.fundacionjala.salesforce.ui;

import org.fundacionjala.salesforce.ui.bar.navbar.NavBar;
import org.fundacionjala.salesforce.ui.bar.navbar.NavBarClassic;
import org.fundacionjala.salesforce.ui.bar.navbar.NavBarLighting;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBarClassic;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBarLighting;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.CLASSIC;
import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.LIGHTNING;
/**
 * [JS]
 */
public final class ComponentFactory {

    /**
     *
     */
    private ComponentFactory() {
    }

    /**
     * [JS] Used for select a NavBar.
     *
     * @param component Parameter content a NavBar Name.
     * @return a NavBar.
     */
    public static NavBar getNavBar(final String component) {
        Map<String, NavBar> componentMap = new HashMap<>();
        componentMap.put(LIGHTNING, new NavBarLighting());
        componentMap.put(CLASSIC, new NavBarClassic());

        return componentMap.get(component);
    }

    /**
     * [JS] Used for select a NavBar.
     *
     * @param component Parameter content a NavBar Name.
     * @return a NavBar.
     */
    public static SideBar getSideBar(final String component) {
        Map<String, SideBar> componentMap = new HashMap<>();
        componentMap.put(LIGHTNING, new SideBarLighting());
        componentMap.put(CLASSIC, new SideBarClassic());

        return componentMap.get(component);
    }
}
