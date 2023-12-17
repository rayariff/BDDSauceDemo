package org.example.pageObject;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    public static WebDriver webDriver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement fieldUserName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement labelProduct;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectProduct;
    @FindBy(xpath = "//h3")
    private WebElement errorMessage;


    public boolean verifyFieldUserName(){
        return fieldUserName.isDisplayed();
    }
    public void inputFieldUserName(String userName){
        fieldUserName.sendKeys(userName);
    }

    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }
    public void clickButtonLogin(){
        buttonLogin.click();
    }

    public boolean verifyLabelProduct(){
        return labelProduct.isDisplayed();
    }

    public void sortProduct(String filter){
        Select sort = new Select(selectProduct);
        sort.selectByVisibleText(filter);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }


}
