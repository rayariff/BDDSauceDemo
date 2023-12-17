package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    public static WebDriver webDriver;
    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectProduct;
    @FindBy(xpath ="//a[.='2']")
    private WebElement iconCart;

    public void sortProduct(String filter){
        Select sort = new Select(selectProduct);
        sort.selectByVisibleText(filter);
    }

    public void clickAddToCartProduct(String product){
        String xpath = "//div[contains(text(),'"+ product+ "')]/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void clickIconCart(){
        iconCart.click();
    }



}
