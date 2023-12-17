package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }


    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement fieldFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement fieldLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement fieldPostalCode;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement buttonContinue;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalElement;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxElement;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalElement;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement buttonFinish;
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeText;





    public void inputFieldFirstName(String firstName){
        fieldFirstName.sendKeys(firstName);
    }

    public void inputFieldLastName(String lastName){
        fieldLastName.sendKeys(lastName);
    }

    public void inputFieldPostalCode(String postalCode){
        fieldPostalCode.sendKeys(postalCode);
    }

    public void clickButtonContinue(){
        buttonContinue.click();
    }
    public boolean verifyTotal() {
        double itemTotal = extractAmount(subTotalElement);
        double tax = extractAmount(taxElement);
        double actualTotal = itemTotal + tax;
        String totalText = totalElement.getText();

        return totalText.contains(String.format("$%.2f", actualTotal));
    }
    public String verifyTotalPrice(){
        double itemTotal = extractAmount(subTotalElement);
        double tax = extractAmount(taxElement);
        double actualTotal = itemTotal + tax;

        // Format the actualTotal as a currency with two decimal places

        // Return the formatted total
        return String.format("$%.2f", actualTotal);
    }

    public String getTotalElement(){
        String totalText = totalElement.getText();
        return totalText.replaceAll("[^\\d.]", "");
    }


    private double extractAmount(WebElement element) {
        String text = element.getText();
        String amountStr = text.replaceAll("[^\\d.]", ""); // Remove non-digit characters
        return Double.parseDouble(amountStr);
    }
    public void clickButtonFinish(){
        buttonFinish.click();
    }
    public boolean verifyCompleteOrder(){
        return completeText.isDisplayed();
    }

}
