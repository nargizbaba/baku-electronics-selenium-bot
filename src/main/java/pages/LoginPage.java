package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/giris/login']")
    private WebElement loginButton;

    @FindBy(id = "E-poçt")
    private WebElement emailInput;

    @FindBy(id = "Şifrə")
    private WebElement passwordInput;

    @FindBy(css = "button.MuiButton-root.login_LoginBtn__GG3cP")
    private WebElement submitButton;


    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmail(String email) {
        waitAndClick(emailInput);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
