package org.fundacionjala.salesforce.ui.pages.contactDetailsPage;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsClassicPage extends ContactDetailsAbstractPage {

    @FindBy(css = "input[name='del']")
    private WebElement btnDelete;


    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

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
        getWebDriver().switchTo().alert().accept();
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void deleteContact() {
        clickBtnDelete();
        clickBtnConfirmDelete();
    }

    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntil(btnDelete);
    }
}
