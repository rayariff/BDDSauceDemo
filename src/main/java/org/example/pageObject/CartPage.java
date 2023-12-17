package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public static WebDriver webDriver;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement buttonCheckout;

    public void clickRemoveProduct(String product){
        String xpath = "//div[contains(text(),'"+product+"')]/ancestor::div[@class='cart_item_label']//button[text()='Remove']";
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void clickButtonCheckout(){
        buttonCheckout.click();
    }
}
