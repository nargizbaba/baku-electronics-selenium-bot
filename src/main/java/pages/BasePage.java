package pages;

import config.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public JavascriptExecutor js;

    public BasePage() {
        this.driver = WebDriverManager.getChromeDriver();
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void waitAndClick(WebElement element) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));

            element.click();
        } catch(RuntimeException e){
            System.out.println("Element not found: " + e.getMessage());
        }
    }
}
