package org.fundacionjala.salesforce.ui.pages.contactDetailsPage;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsLightningPage extends ContactDetailsAbstractPage {

    @FindBy(xpath = "//button[contains(.,'Show more actions')]")
    private WebElement btnMenu;

    @FindBy(xpath = "//a[@name='Delete']")
    private WebElement btnDelete;

    @FindBy(css = "button[title='Delete']")
    private WebElement btnConfirmDelete;

    /**
     * Click in button Menu.
     */
    public void clickButtonMenu() {
        WebDriverHelper.clickElement(btnMenu);
    }

    /**
     * Clicks in button delete.
     */
    public void clickBtnDelete() {
        WebDriverHelper.clickElement(btnDelete);
    }

    /**
     * Click in button delete.
     */
    public void clickBtnConfirmDelete() {
        WebDriverHelper.clickElement(btnConfirmDelete);
    }

    /**
     * Deletes the contact.
     */
    @Override
    public void deleteContact() {
        clickButtonMenu();
        clickBtnDelete();
        clickBtnConfirmDelete();
    }

    /**
     * Verifies if element is loaded.
     */
    @Override
    public void waitUntilPageIsLoaded() {
        WebDriverHelper.waitUntilIsVisible(btnMenu);
    }


}
