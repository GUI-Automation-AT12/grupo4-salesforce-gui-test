package org.fundacionjala.salesforce.ui.bar.navbar;

import java.util.HashMap;
import java.util.Map;

public final class NavBarFactory {

    private static Map<String, NavBar> navBarMap = new HashMap<>();

    /**
     * [JS] Constructor.
     */
    private NavBarFactory() { }
    static {
        navBarMap.put("lighting", new NavBarLighting());
        navBarMap.put("classic", new NavBarClassic());
    }

    /**
     * [JS] Used for select a NavBar.
     * @param navBar Parameter content a NavBar Name.
     * @return a NavBar.
     */
    public static NavBar getNavBar(final String navBar) {
        return navBarMap.get(navBar);
    }
}
