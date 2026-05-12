package org.sf.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sf.automation.base.BaseTest;
import org.sf.automation.pages.LoginPage;
import org.sf.automation.pages.OpportunityPage;
import org.sf.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpportunityTest extends BaseTest {

    @Test(description = "Create a new Opportunity in Salesforce")
    public void testCreateOpportunity() {
        // Login first
        new LoginPage(driver).login(
                ConfigReader.get("sf.username"),
                ConfigReader.get("sf.password")
        );

        // Navigate to Opportunities
        driver.get(ConfigReader.get("sf.url") + "/lightning/o/Opportunity/list");

        OpportunityPage oppPage = new OpportunityPage(driver);
        String oppName = "Test Opp - " + System.currentTimeMillis();
        oppPage.createOpportunity(oppName, "12/31/2025", "Prospecting");

        // Assert the record was created by checking the page title
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains(oppName));
        Assert.assertTrue(driver.getTitle().contains(oppName),
                "Opportunity creation failed");
    }
}
