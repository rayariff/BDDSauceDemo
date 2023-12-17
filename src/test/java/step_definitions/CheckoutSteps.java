package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CheckoutSteps {
    private final WebDriver driver = Hooks.driver;
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    @And("User input valid first name {string}")
    public void inputFieldFirstName(String firstName){
        checkoutPage.inputFieldFirstName(firstName);
    }
    @And("User input valid last name {string}")
    public void inputFieldLastName(String lastName){
        checkoutPage.inputFieldLastName(lastName);
    }
    @And("User input valid postal code {string}")
    public void inputFieldPostalCode(String postalCode){
        checkoutPage.inputFieldPostalCode(postalCode);
    }
    @And("User click continue button")
    public void clickButtonContinue() {
        checkoutPage.clickButtonContinue();
    }

    @Then("User verify total price amount is equals to item price with tax")
    public void verifyTotal(){
        boolean isTotalCorrect = checkoutPage.verifyTotal();
        Assert.assertTrue(isTotalCorrect);
    }
    @Then("User verify total price {string} equals to item price with tax {string}")
    public void verifyTotalPrice(String expectedTotal, String actualTotal) {
        String expected = checkoutPage.verifyTotalPrice();  // Format expected value with "$"
        String actual = "$" + checkoutPage.getTotalElement();  // Format actual value with "$"
        Assert.assertEquals(expected, actual);
    }

    @When("User click finish button")
    public void clickButtonFinish(){
        checkoutPage.clickButtonFinish();
    }

    @Then("User already completing the order")
    public void verifyCompleteOrder() {
        Assert.assertTrue(checkoutPage.verifyCompleteOrder());
    }



}
