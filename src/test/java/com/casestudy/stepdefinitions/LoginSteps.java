package com.casestudy.stepdefinitions;

import com.casestudy.pages.LoginPage;
import com.casestudy.utils.ConfigReader;
import com.casestudy.utils.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("User is on the OrangeHRM login page")
    public void user_is_on_the_orange_hrm_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
    }

    @And("Clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should be redirected to the Dashboard page")
    public void user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String user, String pass) {
        loginPage.usernameInput.sendKeys(user);
        loginPage.passwordInput.sendKeys(pass);
    }

    @Then("User should see an invalid credentials error message")
    public void user_should_see_an_invalid_credentials_error_message() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @When("User clicks on the login button without entering any credentials")
    public void user_clicks_on_the_login_button_without_entering_any_credentials() {
        loginPage.loginButton.click();
    }

    @Then("Required field validation messages should be displayed for both fields")
    public void required_field_validation_messages_should_be_displayed() {
        Assert.assertTrue(loginPage.requiredMessage.isDisplayed());
    }

    @Given("User is already logged in as Admin")
    public void user_is_already_logged_in_as_admin() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        loginPage.usernameInput.sendKeys(ConfigReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @Given("User is on the Dashboard page")
    public void user_is_on_the_dashboard_page() {
        // URL'nin içinde "dashboard" kelimesi belirene kadar maksimum 10 saniye bekle
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("dashboard"));

        // Bekledikten sonra doğrulamayı yap
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }

    @When("User clicks on the user profile dropdown menu")
    public void user_clicks_on_the_user_profile_dropdown_menu() {
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
    }

    @When("Clicks on the Logout option")
    public void clicks_on_the_logout_option() {
        Driver.getDriver().findElement(org.openqa.selenium.By.xpath("//a[text()='Logout']")).click();
    }

    @Then("User should be navigated back to the login screen")
    public void user_should_be_navigated_back_to_the_login_screen() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}