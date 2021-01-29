package org.fundacionjala.salesforce.ui.pages.Calendar.details;

import org.fundacionjala.core.utils.JavascriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LightningEventDetailPage extends EventDetailPage {

    private static String DATA  = "//span[text()='%1$s']/parent::div/following-sibling::div//*[text()='%2$s']";

    /**
     * Constructor.
     */
    public LightningEventDetailPage() {

    }

    /**
     *
     * @param key
     * @param value
     * @return boolean
     */
    @Override
    public boolean isDataDisplayed(final String key, final String value){
        String xpath = String.format(DATA, key, value);
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    public void clickLinkEvent(final String value) {
        String xpath = String.format("a.subjectLink[href*= '%s']", value);
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptHelper.clickElement(element);
    }

}
