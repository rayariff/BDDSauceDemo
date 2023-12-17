package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);

    @When("User sort product by {string}")
    public void sortProduct(String filter){
        inventoryPage.sortProduct(filter);
    }

    @And("User click Add to cart from product {string}")
    public void clickProduct(String product){
        inventoryPage.clickAddToCartProduct(product);
    }

    @And("User click cart icon")
    public void clickIconCart(){
        inventoryPage.clickIconCart();
    }
}
