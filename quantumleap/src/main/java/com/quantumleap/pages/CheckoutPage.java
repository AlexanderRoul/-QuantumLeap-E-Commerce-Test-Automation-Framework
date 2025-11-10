package com.quantumleap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final WebDriver driver; private final WebDriverWait wait;
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");
    private final By completeHeader = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver, WebDriverWait wait) { this.driver = driver; this.wait = wait; }

    public void enterInfo(String f, String l, String p) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postalCode).sendKeys(p);
        driver.findElement(continueBtn).click();
    }

    public void finish() { wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click(); }

    public String getConfirmation() { return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText(); }
}
