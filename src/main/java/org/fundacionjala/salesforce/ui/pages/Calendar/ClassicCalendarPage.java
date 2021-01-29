package org.fundacionjala.salesforce.ui.pages.Calendar;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Event;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.ClassicEventDeatilPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.details.EventDetailPage;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.ClassicCreateEventPopup;
import org.fundacionjala.salesforce.ui.pages.Calendar.popup.CreateEventPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassicCalendarPage extends CalendarPage {

    @FindBy(css = "a[title='New Event']")
    private WebElement btnNewEvent;

    private static final String LINK_EVENT  = "//li[@class='event']/span/a[text()='%s']";

    /**
     * Constructor.
     */
    public ClassicCalendarPage() {

    }

    /**
     * Opens CreateEventPopup
     */
    public CreateEventPopup openCreateEventPop() {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(btnNewEvent));
        JavascriptHelper.clickElement(btnNewEvent);
        return new ClassicCreateEventPopup();
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
        return new ClassicEventDeatilPage();
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
