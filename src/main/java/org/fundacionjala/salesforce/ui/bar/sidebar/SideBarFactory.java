package org.fundacionjala.salesforce.ui.bar.sidebar;


import java.util.HashMap;
import java.util.Map;

public final class SideBarFactory {

    private static Map<String, SideBar> sideBarMap = new HashMap<>();

    /**
     * [JS] Constructor.
     */
    private SideBarFactory() { }
    static {
        sideBarMap.put("lighting", new SideBarLighting());
        sideBarMap.put("classic", new SideBarClassic());
    }

    /**
     * [JS] Used for select a NavBar.
     * @param sideBar Parameter content a NavBar Name.
     * @return a NavBar.
     */
    public static SideBar getSideBar(final String sideBar) {
        return sideBarMap.get(sideBar);
    }
}
