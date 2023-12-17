package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.InventoryPage;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    private final WebDriver driver = Hooks.driver;
    CartPage cartPage = new CartPage(driver);

    @And("User click remove product {string}")
    public void removeProduct(String product){
        cartPage.clickRemoveProduct(product);

    }
    @And("User click checkout button")
    public void clickCheckoutButton() {
        cartPage.clickButtonCheckout();
    }
}
