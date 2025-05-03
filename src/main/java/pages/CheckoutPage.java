package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@name='user.first_name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='user.last_name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='user.phone_number']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[@id='simple-tab-2']")
    private WebElement pickupFromStoreButton;

    @FindBy(xpath = "//span[contains(text(), 'Crescent Mall filialı')]/ancestor::span[contains(@class, 'Checkout_MyAddressContent')]")
    private WebElement crescentMallElement;

    @FindBy(xpath = "//button[contains(@class, 'Checkout_BasketFormPayementOptionItem')]//span[text()='Kartla ödə']")
    private WebElement payWithCard;

    @FindBy(xpath = "//button[contains(@class, 'Checkout_CompleteOrderBtn')]")
    private WebElement completeOrderButton;

    public void proceedToCheckout() throws InterruptedException {
        waitAndClick(proceedToCheckoutButton);
        driver.wait(5000);
        fillNameFields();
    }

    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void enterPickupFromStore() {
        waitAndClick(pickupFromStoreButton);
    }

    public void addressSelection(){
        crescentMallElement.click();
    }

    public void selectCardPayment(){
        payWithCard.click();
    }

    public void clickCompleteOrder() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        completeOrderButton.click();
    }

    private void fillNameFields(){
        firstNameInput.sendKeys("Nargiz");
        lastNameInput.sendKeys("Suleymanli");
    }

}
