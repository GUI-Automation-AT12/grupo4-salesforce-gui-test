package org.fundacionjala.salesforce.ui.pages.tasks.details;

import org.fundacionjala.salesforce.entities.Task;
import org.openqa.selenium.By;

public class LightningTaskDetailsPage extends TaskDetailsPage {

    private String relatedTo = "//div[ div[span[text()='Related To']] and div[span[div[a[text()='%s']]]]]";
    private String dueDate = "//div[ div[span[text()='Due Date']] and div[span[span[text()='%s']]]]";
    private String status = "//div[ div[span[text()='Status']] and div[span[span[text()='%s']]]]";
    private String subject = "//div[ div[span[text()='Subject']] and div[span[span[text()='%s']]]]";

    public LightningTaskDetailsPage() {
        task = new Task();
    }
    @Override
    public void validateTaskInformation(Task task) {
        this.task = task;
    }

    @Override
    public boolean getTextSubject() {
        try {
            return getDriver().findElement(By.xpath(String.format(subject, task.getSubject()))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getTextDueDate() {
        try {
            return getDriver().findElement(By.xpath(String.format(dueDate, task.getDueDate()))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getTextStatus() {
        try {
            return getDriver().findElement(By.xpath(String.format(status, task.getState()))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getTextRelatedTo() {
        try {
            return getDriver().findElement(By.xpath(String.format(relatedTo, task.getRelatedValue()))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
