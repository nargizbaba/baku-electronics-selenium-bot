package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(@class,'MuiButton-root') and span[text()='Səbətə əlavə et']]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@class,'MuiButton-root') and span[text()='Səbətə keç']]")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'sebet_ItemAmount')]/button[text()='+']")
    private WebElement cartAmountIncreaseButton;

    @FindBy(xpath = "//div[contains(@class, 'sebet_ItemAmount')]/button[text()='-']")
    private WebElement cartAmountDecreaseButton;

    @FindBy(className="sebet_ItemRemove__xuwKH")
    private WebElement removeFromCartButton;

    @FindBy(className = "ProductCard_Product__3nHrM")
    private WebElement productLink;

    public void clickCartButtons() {
       waitAndClick(addToCartButton);
       waitAndClick(goToCartButton);
    }

    public void clickOnProduct() {
        waitAndClick(productLink);
    }

    public void increaseProductAmount() {
        waitAndClick(cartAmountIncreaseButton);
    }

    public void decreaseProductAmount() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        waitAndClick(cartAmountDecreaseButton);
    }

    public void removalFromCart() {
        waitAndClick(removeFromCartButton);
    }
}
