package org.fundacionjala.salesforce.ui.pages.recycle;

import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class RecycleBinPageFactory extends BasePage {

    private static Map<String, RecycleBinPage> contactMap = new HashMap<>();
    static {
        contactMap.put("lightning", new LightningRecycleBinPage());
        contactMap.put("classic", new ClassicRecycleBinPage());
    }

    /**
     * Gets a Abstract RecycleBinPage class.
     * @return a RecycleBinPage.
     */
    public static RecycleBinPage getRecycleBinPage() {
        return contactMap.get(APIEnvironment.getInstance().getTypeLayout());
    }
}
