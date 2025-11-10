package com.quantumleap.tests.bdd.steps;

import com.quantumleap.core.BaseTest;
import com.quantumleap.pages.LoginPage;
import com.quantumleap.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddToCartSteps extends BaseTest {
    private ProductsPage products;

    @Given("I am on the Sauce Demo login page")
    public void i_am_on_login_page() {
        // BaseTest opens the page in @BeforeMethod
    }

    @When("I login as \"{string}\" with password \"{string}\"")
    public void i_login_as_with_password(String user, String pass) {
        new LoginPage(driver, wait).enterUsername(user).enterPassword(pass).clickLogin();
        products = new ProductsPage(driver, wait);
    }

    @When("I add the Sauce Labs Backpack to the cart")
    public void i_add_backpack() {
        products.addBackpackToCart();
    }

    @Then("the cart badge should show \"{string}\"")
    public void the_cart_badge_should_show(String expected) {
        Assert.assertEquals(products.getCartCount(), expected);
    }
}
