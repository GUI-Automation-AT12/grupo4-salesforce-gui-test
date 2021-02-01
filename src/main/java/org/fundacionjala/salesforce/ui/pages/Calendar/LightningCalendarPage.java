package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Event;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.EventDetailPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.LightningEventDetailPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.LightningCreateEventPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LightningCalendarPage extends CalendarPage {

    @FindBy(className = "new-event-button")
    private WebElement btnNewEvent;
    private static final String LINK_EVENT  = "//div[contains(@class, 'eventDescription')]/a[text()='%s']";

    /**
     * Constructor.
     */
    public LightningCalendarPage() {

    }

    /**
     * Opens CreateEventPopup
     */
    public CreateEventPopup openCreateEventPop() {
        WebDriverHelper.waitUntilIsVisible(btnNewEvent);
        JavascriptHelper.clickElement(btnNewEvent);
        return new LightningCreateEventPopup();
    }

    /**
     * @param event
     * @return page
     */
    @Override
    public EventDetailPage selectEvent(final Event event) {
        String xpath = String.format(LINK_EVENT,event.getSubject());
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptHelper.clickElement(element);
        return new LightningEventDetailPage();
    }

    /**
     * @param event
     * @return boolean
     */
    @Override
    public boolean isDataDisplayed(final Event event) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(btnNewEvent));
        String xpath = String.format(LINK_EVENT,event.getSubject());
        return getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }
}
