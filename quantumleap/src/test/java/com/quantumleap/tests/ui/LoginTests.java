package com.quantumleap.tests.ui;

import com.quantumleap.core.BaseTest;
import com.quantumleap.pages.LoginPage;
import com.quantumleap.pages.ProductsPage;
import com.quantumleap.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void loginVariations(String user, String pass, boolean shouldSucceed) {
        LoginPage login = new LoginPage(driver, wait);
        login.enterUsername(user).enterPassword(pass).clickLogin();

        if (shouldSucceed) {
            ProductsPage products = new ProductsPage(driver, wait);
            Assert.assertEquals(products.getTitle(), "Products");
        } else {
            Assert.assertTrue(new LoginPage(driver, wait).getError().toLowerCase().contains("locked out"));
        }
    }
}
