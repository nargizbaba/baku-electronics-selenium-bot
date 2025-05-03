package stepDefinition;

import config.ExtentReportUtil;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginStep {

    public  LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Given("the user navigates to the homepage")
    public void navigateToHomepage() {
        String firstPage = "https://new.bakuelectronics.az/";
        loginPage.driver.get(firstPage);
        loginPage.driver.manage().window().maximize();
       // ExtentReportUtil.logStep("the user navigates to the homepage");
        //ExtentReportUtil.logInfo("Entered credentials and clicked login");
    }

    @Given("the user clicks on the login button")
    public void clickingOnLoginButton() {
        //ExtentReportUtil.logStep("the user clicks on the login button");
        loginPage.clickLoginButton();
    }

    @When("the user enters {string} and {string}")
    public void enterCredentials(String email, String password) {
        //ExtentReportUtil.logStep("the user enters {string} and {string}");
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Then("clicks on the 'daxil ol' button and proceeds to the homepage")
    public void clickingOnSubmit() {
        loginPage.clickSubmitButton();
    }
}
