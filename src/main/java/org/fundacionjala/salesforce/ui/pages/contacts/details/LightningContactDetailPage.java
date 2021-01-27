package org.fundacionjala.salesforce.ui.pages.contacts.details;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.utils.JavascriptHelper;
import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class LightningContactDetailPage extends ContactDetailsPage {


    @FindBy(xpath = "//button[contains(@class,'slds-button--brand testid__dummy-button-submit-action')]")
    private WebElement addTask;

    @FindBy(xpath = "//div[@class='slds-tabs_card']//div[contains(@class,'slds-combobox__form-element')]/input")
    private WebElement asset;

    @FindBy(xpath = "//div[contains(@class,'uiInput--datetime')]/input")
    private WebElement expirationDate;

    @FindBy(xpath = "//div[contains(@class,'contentWrapper')]//div[contains(@class,'entityMenu')]/div[@class='uiPopupTrigger']//a")
    private WebElement relatedWith;

    @FindBy(xpath = "//a[@class='select' and contains(@href,'javascript')]")
    private String relatedElement = "div[class*='contentWrapper'] div[class*='autocompleteWrapper'] input[title*='Search %s']";
    private String subject = "//lightning-base-combobox-item[@data-value='%s']";
    private String typeOfRelation = "//li[contains(@class,'entityMenuItem')]/a[contains(@role,'menuitem') and contains(@title,'%s')]";
    private String relatedElementList = "//a[@role='option']//div[@title='%s']";
    private String status = "//a[text()='Not Started']";
    private String StatusList = "//parent::li[@role='presentation']/a[text()='%s']";
    private String saveTask = "//div[contains(@class,'activeState')]//button[contains(@class,'slds-button--brand')]";
    private String createdTask = "//a[@title='%s']";

    public LightningContactDetailPage() {
        WebDriverHelper.waitUntil(addTask);
            task = new Task();
    }

    /**
     * this method select the relation and the relation value.
     */
    private void relatedTo() {
        try {
            Thread.sleep(2000);
            JavascriptHelper.clickElement(relatedWith);//
            By dropDownRelatedWith = By.xpath(String.format(typeOfRelation, task.getRelatedWith()));
            WebDriverHelper.clickElement(dropDownRelatedWith); //
            WebElement related = driver.findElement(By.cssSelector(String.format(relatedElement, task.getRelatedWith())));
            WebDriverHelper.setElement(related, task.getRelatedValue());
            WebElement elementOnList = driver.findElement(By.xpath(String.format(relatedElementList, task.getRelatedValue())));
            JavascriptHelper.clickElement(elementOnList);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTask(Map<String, String> taskInformation) {
        task.processInformation(taskInformation);
        JavascriptHelper.clickElement(addTask);
        WebDriverHelper.setElement(asset, task.getSubject());
        WebDriverHelper.clickElement(By.xpath(String.format(subject, task.getSubject())));
        WebDriverHelper.setElement(expirationDate, task.getDueDate());
        relatedTo();
        JavascriptHelper.clickElement(driver.findElement(By.xpath(status)));
        JavascriptHelper.clickElement(driver.findElement(By.xpath(String.format(StatusList, task.getState()))));
        JavascriptHelper.clickElement(driver.findElement(By.xpath(saveTask)));
        selectCreatedTask(task);
    }

    public void selectCreatedTask(Task task) {
       JavascriptHelper.clickElement(driver.findElement(By.xpath(String.format(createdTask, task.getSubject()))));
    }

    @Override
    public Task getTask() {
        return task;
    }

}
