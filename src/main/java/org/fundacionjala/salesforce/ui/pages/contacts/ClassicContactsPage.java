package org.fundacionjala.salesforce.ui.pages.contacts;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassicContactsPage  extends ContactsPage{

	@FindBy(id="phSearchInput")
	private WebElement txtSearch;

	@FindBy(xpath="//div/h2[@class='topName']")
	private WebElement nameTitle;

	String linkContact ="//table/tbody//tr//td//th//a[text()=' %S']";
	String nameContact;
    @Override
    public void setSearch(String contact) {
        WebDriverHelper.waitUntil(txtSearch);
        WebDriverHelper.setElement(txtSearch, contact);
        nameContact = contact;
    }

    @Override
    public void searchContact(String contact) {
        setSearch(contact);
        txtSearch.sendKeys(Keys.ENTER);
    }

    @Override
    public void findContact(String contact) {
        String text = changeInitials(String.format(linkContact,contact).toLowerCase());
        WebElement element = driver.findElement(By.xpath(changeInitials(text.replaceAll("=' ","='"))));
        WebDriverHelper.waitUntil(element);
        WebDriverHelper.clickElement(element);
    }

    @Override
    public void selectContact(String id) {
        findContact(nameContact);
    }

    @Override
    public String getContactName(String id) {
        return WebDriverHelper.getTextElement(nameTitle);
    }

    public String changeInitials(String text) {
        String[] split = text.split("");
        for (int i = 0; i < split.length; i++) {
            if(i == 0 || split[i-1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            }
        }
        return String.join("", split);
    }
}
