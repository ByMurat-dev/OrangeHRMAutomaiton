package com.casestudy.pages;
import com.casestudy.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() { PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(name = "username") public WebElement usernameInput;
    @FindBy(name = "password") public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']") public WebElement loginButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']") public WebElement errorMessage;
    @FindBy(xpath = "//span[text()='Required']") public WebElement requiredMessage;
}