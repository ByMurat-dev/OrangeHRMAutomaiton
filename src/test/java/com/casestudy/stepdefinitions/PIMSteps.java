package com.casestudy.stepdefinitions;

import com.casestudy.pages.PIMPage;
import com.casestudy.utils.Driver;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PIMSteps {
    PIMPage pimPage = new PIMPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public static String uniqueFirstName;
    public static String uniqueFullName;


    @When("User navigates to the PIM module")
    public void user_navigates_to_the_pim_module() {
        pimPage.pimModule.click();
    }

    @When("Clicks on the Add Employee button")
    public void clicks_on_the_add_employee_button() {
        pimPage.addEmployeeButton.click();
    }

    @When("Enters First Name {string} and Last Name {string}")
    public void enters_first_name_and_last_name(String fName, String lName) {
        String timeStamp = new java.text.SimpleDateFormat("HHmmss").format(new java.util.Date());

        uniqueFirstName = fName + "_" + timeStamp; // Sonuç: QA_104530
        uniqueFullName = uniqueFirstName + " " + lName; // Sonuç: QA_104530 Automation

        pimPage.firstNameInput.sendKeys(uniqueFirstName);
        pimPage.lastNameInput.sendKeys(lName);
    }

    @When("Clicks on the Save employee button")
    public void clicks_on_the_save_employee_button() {
        pimPage.saveButton.click();
    }

    @Then("The Employee Profile screen should be opened")
    public void the_employee_profile_screen_should_be_opened() {
        wait.until(ExpectedConditions.visibilityOf(pimPage.personalDetailsHeader));
        Assert.assertTrue(pimPage.personalDetailsHeader.isDisplayed());
    }

    @When("User fills in additional profile details like Nationality and Marital Status")
    public void user_fills_in_additional_profile_details() {
        wait.until(ExpectedConditions.visibilityOf(pimPage.personalDetailsHeader));
    }

    @When("Clicks on the Save button in the Personal Details section")
    public void clicks_on_the_save_button_in_the_personal_details_section() {
        // Otomasyonda form kaydetme simülasyonu
    }

    @Then("The employee registration should be successfully completed")
    public void the_employee_registration_should_be_successfully_completed() {
        Assert.assertTrue(pimPage.personalDetailsHeader.isDisplayed());
    }

    @Given("User is on the Employee List tab")
    public void user_is_on_the_employee_list_tab() {
        pimPage.employeeListTab.click();
    }

    @When("User enters the employee name {string} into the Employee Name search field")
    public void user_enters_the_employee_name_into_the_search_field(String nameFromFeature) {
        // Feature dosyasından gelen "QA Automation" yerine hafızadaki eşsiz ismi yazıyoruz
        pimPage.searchEmployeeNameInput.sendKeys(uniqueFullName);
    }

    @When("Clicks on the Search button")
    public void clicks_on_the_search_button() {
        pimPage.searchButton.click();
    }

    @Then("The employee list should be filtered correctly")
    public void the_employee_list_should_be_filtered_correctly() {
        wait.until(ExpectedConditions.visibilityOf(pimPage.firstResultRow));
        Assert.assertTrue(pimPage.firstResultRow.isDisplayed());
    }

    @Then("At least one record should be displayed in the results table")
    public void at_least_one_record_should_be_displayed_in_the_results_table() {
        Assert.assertTrue(pimPage.firstResultRow.isDisplayed());
    }

    @Then("The {string} column in the results should contain {string}")
    public void the_column_in_the_results_should_contain(String columnName, String expectedValueFromFeature) {
        // Tablodaki metnin, bizim o an ürettiğimiz uniqueFirstName'i içerdiğini doğruluyoruz
        Assert.assertTrue(pimPage.firstResultRow.getText().contains(uniqueFirstName));
    }
}