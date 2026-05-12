package org.sf.automation.base;

import org.openqa.selenium.WebDriver;
import org.sf.automation.utils.ConfigReader;
import org.sf.automation.utils.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("sf.url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
