package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("User already on login page")
    public void verifyUserName(){
        Assert.assertTrue(loginPage.verifyFieldUserName());
    }

    @When("User input {string} as username")
    public void inputFieldUsername(String userName){
        loginPage.inputFieldUserName(userName);
    }

    @And("User input {string} as password")
    public void inputFieldPassword(String password){
        loginPage.inputFieldPassword(password);
    }

    @And("User click button login")
    public void clickButtonLogin(){
        loginPage.clickButtonLogin();
    }
    @And("User input {string} as userName and {string} as password")
    public void credential(String userName, String password){
        loginPage.inputFieldUserName(userName);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonLogin();
    }
    @Then("User already on inventory page")
    public void verifyLabelProduct(){
        Assert.assertTrue(loginPage.verifyLabelProduct());
    }


    @Then("User see {string} as error message")
    public void verifyErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

}
