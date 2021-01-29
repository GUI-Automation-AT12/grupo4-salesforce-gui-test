package org.fundacionjala.salesforce.ui.pages.Calendar.details;

import org.openqa.selenium.By;

public class ClassicEventDeatilPage extends EventDetailPage {

    private static String DATA  = "//table[@class='detailList']/tbody/tr/td[@class='labelCol' and text()='%1s']/following-sibling::td//*[text()='%2s']";


    /**
     * Constructor.
     */
    public ClassicEventDeatilPage() {

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

}
