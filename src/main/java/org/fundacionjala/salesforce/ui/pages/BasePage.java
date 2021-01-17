package org.fundacionjala.salesforce.ui.pages;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected BasePage() {
        PageFactory.initElements(WebDriverManager.getInstance().getWebDriver(), this);
    }
}
