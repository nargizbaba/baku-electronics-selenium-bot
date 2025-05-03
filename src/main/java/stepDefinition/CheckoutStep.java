package stepDefinition;

import io.cucumber.java.en.*;
import pages.CheckoutPage;

public class CheckoutStep {
    public static CheckoutPage checkoutPage;

    public CheckoutStep() {
        checkoutPage = new CheckoutPage();
    }

    @Given("the user clicks on the Proceed to Checkout button")
    public void clickButton() throws InterruptedException {
        checkoutPage.proceedToCheckout();
    }

    @When("the user enters their phone number {string}")
    public void enterPhoneNumber(String phone_number) {
        checkoutPage.enterPhoneNumber(phone_number);
    }

    @And("the user selects the location to pick up the product")
    public void selectPickupLocation() {
        checkoutPage.enterPickupFromStore();
        checkoutPage.addressSelection();
    }

    @And("the user chooses the payment method")
    public void selectPaymentMethod() {
        checkoutPage.selectCardPayment();
    }

    @Then("the user completes the order")
    public void completeOrder() {
        checkoutPage.clickCompleteOrder();
    }
}
