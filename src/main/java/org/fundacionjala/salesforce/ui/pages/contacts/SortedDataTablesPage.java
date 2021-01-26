package org.fundacionjala.salesforce.ui.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedDataTablesPage {


    private static final String TD_XPATH = "td[@class='%1$s' and text()='%2$s']";
    private static final String TD_XPATH2 = "td[%1$s][text()='%2$s']";

    private static HashMap<String, String> HEADER_CLASS_MAP = new HashMap<>();
    static {
        HEADER_CLASS_MAP.put("Due", "dues");
    }

    private WebDriver driver;

    public SortedDataTablesPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isUserInformationDisplayed(final HashMap<String, String> userInfo) {
        return driver.findElement(By.xpath(createLocator(userInfo))).isDisplayed();
    }

    private static String createLocator(final HashMap<String, String> userInfo) {
        String rowXpathLocator = "//tr[";
        for(Map.Entry entry : userInfo.entrySet()) {
            if(!"//tr[".equals(rowXpathLocator)) {
                rowXpathLocator += " and ";
            }
            rowXpathLocator += String.format(TD_XPATH, getClassValue(entry.getKey().toString()), entry.getValue());
        }
        return rowXpathLocator + "]";
    }

//    private static String createLocator2(final HashMap<String, String> userInfo) {
//        String rowXpathLocator = userInfo.entrySet().stream().map(entry ->
//            String.format(TD_XPATH, getClassValue(entry.getKey().toString()), entry.getValue()))
//        .collect(Collectors.joining(" and ", "//tr[", "]"));
//        return rowXpathLocator;
//    }

    private static String getClassValue(final String header) {
        return HEADER_CLASS_MAP.getOrDefault(header, header.toLowerCase().replaceAll(" ", "-"));
    }

    public static void main(String[] args) {
        HashMap<String, String> userInfo =  new HashMap<>();
        userInfo.put("Last Name", "Doe");
        userInfo.put("First Name", "Jason");
        userInfo.put("Email", "jdoe@hotmail.com");
        System.out.println(createLocator(userInfo));
    }

    public boolean isUserInformationDisplayedNoClass(HashMap<String, String> userInfo) {
        return driver.findElement(By.xpath(createLocator2(userInfo))).isDisplayed();
    }

    private String createLocator2(final HashMap<String, String> userInfo) {
        String rowXpathLocator = "//table[@id='table1']//tr[";
        for(Map.Entry entry : userInfo.entrySet()) {
            if(!"//table[@id='table1']//tr[".equals(rowXpathLocator)) {
                rowXpathLocator += " and ";
            }
            rowXpathLocator += String.format(TD_XPATH2, getHeaderPosition(entry.getKey().toString()),entry.getValue());
        }
        return rowXpathLocator + "]";
    }

    private String getHeaderPosition(String key) {
        By headersBy = By.cssSelector("#table1 .header span");
        ArrayList<String> headerText = new ArrayList<>();
        for (WebElement header : driver.findElements(headersBy)) {
            headerText.add(header.getText());
        }
        return String.valueOf(headerText.indexOf(key) + 1);
    }
}
