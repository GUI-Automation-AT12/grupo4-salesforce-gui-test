package org.fundacionjala.salesforce.ui.bar.navbar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBarFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarClassic extends NavBar {

    @FindBy(id = "setupLink")
    private WebElement linkConfiguration;

    private void clickConfigurationLink() {
        WebDriverHelper.clickElement(linkConfiguration);
    }


    /**
     *
     * @return the sidebar.
     */
    @Override
    public SideBar goToConfigurations() {
        clickConfigurationLink();
        return SideBarFactory.getSideBar(APIEnvironment.getInstance().getTypeLayout());

    }
}
