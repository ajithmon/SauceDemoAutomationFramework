package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(css = ".btn")
    List<WebElement> addToCartBtn;

    @FindBy(css = ".btn")
    WebElement addToCart;

    @FindBy(css = ".inventory_item_name ")
    List<WebElement> productTitleList;

    @FindBy(css = ".shopping_cart_badge")
    WebElement cartQty;

    @FindBy(css = ".inventory_details_desc_container")
    WebElement productDetails;

    @FindBy(css = ".product_sort_container")
    WebElement catElement;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement>priceOfItem;

    @FindBy(id = "react-burger-menu-btn")
    WebElement sideMenuBtn;

    String sideMenuOptions = "%s_sidebar_link";

    @FindBy(css = ".inventory_details_img")
    WebElement productImage;


    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void userAddProductToCart(String productName){
        for (WebElement product:productTitleList){
            if(product.getText().equals(productName)){
                addToCart.click();
            }
        }
    }

    public int getCartQuantity(){
        return Integer.parseInt(cartQty.getText());
    }

    public void clickOnCartIcon(){
        shoppingCartLink.click();
    }

    public void userClickOnProduct(){
        productTitleList.getFirst().click();
    }

    public boolean verifyProductDetails() {
        try {
            String expectedText = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/file/expected.txt")),
            StandardCharsets.UTF_8).replaceAll("\\s+", " ").trim();
            String actualText = productDetails.getText().replaceAll("\\s+", " ").trim();
            return expectedText.contentEquals(actualText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectCategory(String option){
        Select catSelect = new Select(catElement);
        catSelect.selectByVisibleText(option);
    }

    public boolean isProductsSortBY(String option) {    
        if (option.equals("Price (low to high)")) {        
            for (int i = 0; i < priceOfItem.size() - 1; i++) {            
                double firstValue = Double.parseDouble(priceOfItem.get(i).getText().replace("$",""));
                double secondValue = Double.parseDouble(priceOfItem.get(i + 1).getText().replace("$",""));
                if (firstValue > secondValue)                
                    return false;        
            }    
        } else if (option.equals("Name (A to Z)")) {        
            for (int i = 0; i < productTitleList.size() - 1; i++) {            
                String firstValue = productTitleList.get(i).getText();            
                String secondValue = productTitleList.get(i + 1).getText();            
                if (firstValue.compareTo(secondValue) > 0)                
                    return false;        
            }
        }
        return true;
    }

    public void selectSideMenuOption(String option){
        sideMenuBtn.click();
        driver.findElement(By.id(String.format(sideMenuOptions,option))).click();
    }

    public boolean isCartBecomesEmpty() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        try {
            return cartQty.isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    public void addMultipleProducts() {
        for(int i = 0; i<Integer.parseInt(ConfigReader.getConfigValue("count")); i++){
            addToCartBtn.get(i).click();
        }
    }

    public boolean isProductImageVisible() {
        try {
            return productImage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
