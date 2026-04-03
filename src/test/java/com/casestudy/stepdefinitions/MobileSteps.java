package com.casestudy.stepdefinitions;

import com.casestudy.utils.MobileDriver;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class MobileSteps {

    // --- AKILLI VE SABIRLI ELEMENT BULUCU (EXPLICIT WAIT) ---
    // Element ekranda görünene kadar maksimum 15 saniye bekler.
    private WebElement findElementByText(String text) {
        String dynamicXpath = "//*[@text='" + text + "' or @content-desc='" + text + "']";
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(dynamicXpath)));
    }

    @Given("The user launches the ApiDemos application")
    public void the_user_launches_the_api_demos_application() {
        MobileDriver.getMobileDriver();
    }

    @Then("The application should be opened successfully")
    public void the_application_should_be_opened_successfully() {
        Assert.assertNotNull(MobileDriver.getMobileDriver().currentActivity());
    }

    @Then("The title {string} should be visible on the screen")
    @Then("The {string} detail screen should be opened successfully")
    public void the_text_should_be_visible_on_the_screen(String text) {
        Assert.assertTrue(findElementByText(text).isDisplayed());
    }

    @When("The user taps on the {string} menu")
    @When("The user taps on the {string} option")
    @When("The user taps on the {string} button")
    @When("The user taps on the {string} item")
    @When("The user taps on the {string} button on the alert")
    public void the_user_taps_on_dynamic_element(String text) {
        findElementByText(text).click();
    }

    @Then("An alert dialog should be displayed on the screen")
    public void an_alert_dialog_should_be_displayed_on_the_screen() {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), Duration.ofSeconds(15));
        WebElement alertTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/alertTitle")));
        Assert.assertTrue(alertTitle.isDisplayed());
    }

    @Then("The alert dialog should be closed successfully")
    public void the_alert_dialog_should_be_closed_successfully() {
        Assert.assertTrue(findElementByText("Alert Dialogs").isDisplayed());
    }

    @When("The user enters {string} into the text input field")
    public void the_user_enters_into_the_text_input_field(String text) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), Duration.ofSeconds(15));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
        inputField.sendKeys(text);
    }

    @When("The user taps on the checkbox to toggle its state")
    public void the_user_taps_on_the_checkbox_to_toggle_its_state() {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), Duration.ofSeconds(15));
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.CheckBox")));
        checkBox.click();
    }

    @Then("The checkbox should be selected")
    public void the_checkbox_should_be_selected() {
        WebDriverWait wait = new WebDriverWait(MobileDriver.getMobileDriver(), Duration.ofSeconds(15));
        WebElement checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.CheckBox")));
        Assert.assertEquals(checkBox.getAttribute("checked"), "true");
    }

    @When("The user scrolls down to find the {string} item")
    public void the_user_scrolls_down_to_find_the_item(String text) {
        // Scroll işlemi Android'in kendi motoruyla yapıldığı için kendi içinde bekleme süresine sahiptir.
        MobileDriver.getMobileDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }
}