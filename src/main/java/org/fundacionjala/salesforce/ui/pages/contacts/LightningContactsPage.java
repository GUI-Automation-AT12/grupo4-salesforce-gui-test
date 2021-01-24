package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LightningContactsPage extends ContactsPage{
    @FindBy(xpath = "//input[@name='Contact-search-input']")
    private WebElement search;

    @FindBy(xpath = "//table//tbody/tr//a[contains(text(),'Test Contact2 Example Account')]//ancestor::tr//div[@data-aura-class='forceVirtualAction']/a")
    private WebElement btnMenu;

    private String xpathbtn = "//table//tbody/tr//a[contains(text(),'%s')]//ancestor::tr//div[@data-aura-class='forceVirtualAction']/a";

    private String contactListed = "//tbody//a[contains(@href,'%s')]";

    public LightningContactsPage() {

    }

    public void setSearch(final String contact) {
        WebDriverHelper.waitUntil(search);
        WebDriverHelper.setElement(search, contact);
    }

    public void searchContact (final String contact){
        setSearch(contact);
        search.sendKeys(Keys.ENTER);
    }

    public void findContact(String contact) {
        WebElement element = WebDriverManager.getInstance().getWebDriver()
                .findElement(By.xpath(String.format(xpathbtn,contact)));
        WebDriverHelper.clickElement(element);
    }

    public void selectContact(final String id) {
        WebElement contact = driver.findElement(By.xpath(String.format(contactListed, id)));
        WebDriverHelper.clickElement(contact);
    }
}
