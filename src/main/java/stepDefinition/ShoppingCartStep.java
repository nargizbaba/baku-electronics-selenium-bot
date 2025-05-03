package stepDefinition;

import io.cucumber.java.en.*;
import pages.ShoppingCartPage;

public class ShoppingCartStep {
        public static ShoppingCartPage shoppingCartPage;

    public ShoppingCartStep() {
        shoppingCartPage = new ShoppingCartPage();
    }

    @Given("the user adds notebook to shopping cart")
    public void selectDesiredComputer() {
        clickProductFromCatalog("https://new.bakuelectronics.az/catalog/noutbuklar-komputerler-planshetler/noutbuklar");
        addItemToShoppingCart();
    }

    @When("the user updates the quantity of the notebook by increasing it")
    public void addOnNotebookQuantity(){
        shoppingCartPage.increaseProductAmount();
    }

    @And("the user updates the quantity of the notebook by decreasing it")
    public void decreaseNotebookQuantity() throws InterruptedException {
        shoppingCartPage.decreaseProductAmount();
    }

    @Then("the user removes the notebook from the shopping cart")
        public void removeNotebookFromShoppingCart() {
        shoppingCartPage.removalFromCart();
    }

    @Given("the user adds smartphone to shopping cart")
    public void selectDesiredSmartphone() {
        clickProductFromCatalog("https://new.bakuelectronics.az/catalog/telefonlar-qadcetler/smartfonlar-mobil-telefonlar");
        addItemToShoppingCart();
    }

    @When ("the user updates the quantity of the smartphone by increasing it")
    public void addOnSmartphoneQuantity(){
        shoppingCartPage.increaseProductAmount();
    }

    @And ("the user updates the quantity of the smartphone by decreasing it")
    public void decreaseSmartphoneQuantity() throws InterruptedException {
        shoppingCartPage.decreaseProductAmount();
    }

    @Then("the user removes the smartphone from the shopping cart")
    public void removeSmartphoneFromShoppingCart() {
        shoppingCartPage.removalFromCart();
    }

    private void addItemToShoppingCart() {
        shoppingCartPage.clickCartButtons();
    }

    private void clickProductFromCatalog(String url) {
        shoppingCartPage.driver.get(url);
        shoppingCartPage.clickOnProduct();
    }
}
