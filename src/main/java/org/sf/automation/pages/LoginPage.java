package org.sf.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sf.automation.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernamefield;
    @FindBy(id = "password")
    private WebElement passwordfield;
    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernamefield));
        usernamefield.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordfield));
        passwordfield.sendKeys(password);
        loginButton.click();
    }

}
