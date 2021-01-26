package org.fundacionjala.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.core.config.ExecuteProperties;
import org.fundacionjala.salesforce.utils.setup.SetupHelper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        plugin = {"pretty", "json:build/jsonTarget/cucumber.json", "html:build/jsonTarget/site/cucumber.html"},
        features = {"src/test/resources/features"},
        glue = {""}
)
public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
    * Executes code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
//        SetupHelper setupHelper = new SetupHelper();
//        setupHelper.setupContacts();
//        setupHelper.setupCampaigns();
//        setupHelper.setupOpportunities();
    }
}
