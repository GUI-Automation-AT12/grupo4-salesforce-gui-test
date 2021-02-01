package org.fundacionjala.salesforce.ui.bar.navbar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.ui.ComponentFactory;
import org.fundacionjala.salesforce.ui.bar.sidebar.SideBar;
import org.fundacionjala.salesforce.ui.transporter.TransporterPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarLighting extends NavBar {
    @FindBy(css = "#setup > path:nth-child(1)")
    private WebElement dropDownAccount;

    @FindBy(xpath = "//div[@class='profile-card-toplinks']//a[@class='profile-link-label']")
    private WebElement configurationLink;

    private void clickDropDownAccount() {
        WebDriverHelper.clickElement(dropDownAccount);
    }

    private void clickConfigurationLink() {
        WebDriverHelper.clickElement(configurationLink);
    }

    /**
     *
     * @return the sidebar.
     */
    @Override
    public SideBar goToConfigurations() throws Exception {
        TransporterPage.navigateToPage("Setup");
        return ComponentFactory.getSideBar(APIEnvironment.getInstance().getTypeLayout());
    }
}
