package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {}

    public static WebDriver getChromeDriver(){

        if(driver == null)
        {
            InitChromeDriver();
        }

        return driver;
    }

    private static void InitChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
