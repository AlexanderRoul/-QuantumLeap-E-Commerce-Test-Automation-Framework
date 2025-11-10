package com.quantumleap.tests.ui;

import com.github.javafaker.Faker;
import com.quantumleap.core.BaseTest;
import com.quantumleap.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseFlowTests extends BaseTest {

    @Test
    public void endToEndPurchase() {
        LoginPage login = new LoginPage(driver, wait);
        login.enterUsername("standard_user").enterPassword("secret_sauce").clickLogin();

        ProductsPage products = new ProductsPage(driver, wait);
        products.addBackpackToCart();
        Assert.assertEquals(products.getCartCount(), "1");
        products.goToCart();

        CartPage cart = new CartPage(driver, wait);
        Assert.assertTrue(cart.hasItems(), "Cart should have at least one item");
        cart.clickCheckout();

        Faker faker = new Faker();
        CheckoutPage checkout = new CheckoutPage(driver, wait);
        checkout.enterInfo(faker.name().firstName(), faker.name().lastName(), faker.address().zipCode());
        checkout.finish();

        Assert.assertTrue(checkout.getConfirmation().toLowerCase().contains("thank you"));
    }
}
