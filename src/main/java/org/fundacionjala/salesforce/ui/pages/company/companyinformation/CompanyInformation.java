package org.fundacionjala.salesforce.ui.pages.company.companyinformation;

import org.fundacionjala.core.selenium.WebDriverHelper;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.salesforce.config.APIEnvironment;
import org.fundacionjala.salesforce.entities.Company;
import org.fundacionjala.salesforce.ui.pages.BasePage;
import org.fundacionjala.salesforce.ui.pages.company.companyform.CompanyForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static org.fundacionjala.salesforce.entities.constants.LayoutConstants.LIGHTNING;

/**
 * [JS]
 */
public class CompanyInformation extends BasePage {

    @FindBy(xpath = "//html/body/div[5]/div[1]/table/tbody/tr/td[2]/input[1]")
    private WebElement btnUpdate;

    @FindBy(xpath = "//div//iframe[contains(@title,'Company')]")
    private WebElement iframeXpath;


    private static final String FIELD_VALUE_XPATH = "//td[text()=' %S']/following-sibling::td[1]";

    /**
     *
     */
    public CompanyInformation() {
    }

    /**
     * @param typeLayout
     */
    private void goToTheIframe(final String typeLayout) {
        if (typeLayout.equals(LIGHTNING)) {
            WebDriverHelper.frameToBeAvailableAndSwitchToIt(iframeXpath);
        }
    }

    /**
     * Click button update.
     */
    private void clickButtonUpdate() {
        goToTheIframe(APIEnvironment.getInstance().getTypeLayout());
        WebDriverHelper.clickElement(By.name("edit"));
    }

    /**
     * @param listCompany
     * @return CompanyForm
     */
    public CompanyForm goToTheForm(final ArrayList<Company> listCompany) {
        clickButtonUpdate();
        return new CompanyForm();
    }

    /**
     * @param fields
     * @return hashMap
     */
    public HashMap<String, String> getCompanyInformation(final Set<String> fields) {
        goToTheIframe(APIEnvironment.getInstance().getTypeLayout());
        HashMap<String, String> companyInformation = new HashMap<>();
        fields.forEach(field -> {
            String text = changeInitials(String.format(FIELD_VALUE_XPATH, field).toLowerCase());
            String value = WebDriverHelper.getTextElement(
                    WebDriverManager.getInstance().getWebDriver().findElement(
                            By.xpath(changeInitials(text.replaceAll("=' ", "='")))));
            companyInformation.put(field, value);
        });

        return companyInformation;
    }

    /**
     *
     * @param text
     * @return the string change the initials.
     */
    public String changeInitials(final String text) {
        String[] split = text.split("");
        for (int i = 0; i < split.length; i++) {
            if (i == 0 || split[i - 1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            }
        }
        return String.join("", split);
    }
}
