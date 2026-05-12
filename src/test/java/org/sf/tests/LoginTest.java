package org.sf.tests;


import org.sf.automation.base.BaseTest;
import org.sf.automation.pages.LoginPage;
import org.sf.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify successful Salesforce login")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("sf.username"),
                ConfigReader.get("sf.password")
        );
        // After login, URL should contain "lightning" or "home"
        Assert.assertTrue(driver.getCurrentUrl().contains("lightning"),
                "Login failed — unexpected URL: " + driver.getCurrentUrl());
    }
}