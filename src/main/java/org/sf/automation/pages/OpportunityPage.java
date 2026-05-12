package org.sf.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sf.automation.base.BasePage;

public class OpportunityPage extends BasePage {

    // "New" button on the Opportunities list view
    @FindBy(xpath = "//div[@title='New']")
    private WebElement newButton;

    // Opportunity Name field in the creation modal
    @FindBy(xpath = "//input[@placeholder='Opportunity Name']")
    private WebElement oppNameField;

    // Close Date
    @FindBy(xpath = "//input[@placeholder='Close Date']")
    private WebElement closeDateField;

    // Stage dropdown
    @FindBy(xpath = "//button[@aria-label='Stage']")
    private WebElement stageDropdown;

    // Save button
    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveButton;

    public OpportunityPage(WebDriver driver) {
        super(driver);
    }

    public void createOpportunity(String name, String closeDate, String stage) {
        wait.until(ExpectedConditions.elementToBeClickable(newButton)).click();
        wait.until(ExpectedConditions.visibilityOf(oppNameField)).sendKeys(name);
        closeDateField.sendKeys(closeDate);
        stageDropdown.click();
        // Select stage option from dropdown
        driver.findElement(
                org.openqa.selenium.By.xpath("//span[@title='" + stage + "']")
        ).click();
        saveButton.click();
    }
}
