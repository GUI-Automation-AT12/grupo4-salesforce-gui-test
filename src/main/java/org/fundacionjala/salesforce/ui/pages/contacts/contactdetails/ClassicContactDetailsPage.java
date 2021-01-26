package org.fundacionjala.salesforce.ui.pages.contacts.contactdetails;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ClassicContactDetailsPage extends ContactDetailsPage {

    @FindBy(css = "input[name='del']")
    private WebElement btnDelete;


    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

    /**
     * @param taskInformation
     */
    @Override
    public void createTask(final Map<String, String> taskInformation) {

    }

    /**
     * @return task
     */
    @Override
    public Task getTask() {
        return null;
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void clickBtnDelete() {
        WebDriverHelper.clickElement(btnDelete);
    }

    /**
     * Click in button delete.
     */
    @Override
    public void clickBtnConfirmDelete() {
        getDriver().switchTo().alert().accept();
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void deleteContact() {
        clickBtnDelete();
        clickBtnConfirmDelete();
    }

    /**
     * Waits until page is loaded.
     */
    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntil(btnDelete);
    }

}
