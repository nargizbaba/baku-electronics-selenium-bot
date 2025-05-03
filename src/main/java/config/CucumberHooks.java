package config;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportUtil.startTest(scenario.getName());
        ExtentReportUtil.logInfo("Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportUtil.logFail("Scenario failed: " + scenario.getName());
        } else {
            ExtentReportUtil.logPass("Scenario passed: " + scenario.getName());
        }
        ExtentReportUtil.endTest();
    }
}
