package com.quantumleap.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private final WebDriver driver; private final WebDriverWait wait;
    private final By title = By.cssSelector(".title");
    private final By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver, WebDriverWait wait) { this.driver = driver; this.wait = wait; }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void addBackpackToCart() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBackpack));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }

    public String getCartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }

    public void goToCart() { driver.findElement(cartLink).click(); }
}
