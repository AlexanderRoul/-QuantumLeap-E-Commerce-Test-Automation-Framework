package com.quantumleap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final WebDriver driver; private final WebDriverWait wait;
    private final By cartItem = By.cssSelector(".cart_item");
    private final By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait wait) { this.driver = driver; this.wait = wait; }

    public boolean hasItems() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem)).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
