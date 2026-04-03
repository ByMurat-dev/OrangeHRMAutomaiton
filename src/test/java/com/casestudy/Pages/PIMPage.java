package com.casestudy.pages;

import com.casestudy.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
    public PIMPage() { PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "//span[text()='PIM']") public WebElement pimModule;
    @FindBy(xpath = "//a[text()='Add Employee']") public WebElement addEmployeeButton;
    @FindBy(name = "firstName") public WebElement firstNameInput;
    @FindBy(name = "lastName") public WebElement lastNameInput;
    @FindBy(xpath = "//button[@type='submit']") public WebElement saveButton;

    // Profil Detayları (Personal Details)
    @FindBy(xpath = "//h6[text()='Personal Details']") public WebElement personalDetailsHeader;
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]") public WebElement nationalityDropdown;

    // Arama Ekranı
    @FindBy(xpath = "//a[text()='Employee List']") public WebElement employeeListTab;
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]") public WebElement searchEmployeeNameInput;
    @FindBy(xpath = "//button[@type='submit']") public WebElement searchButton;
    @FindBy(xpath = "//div[@class='oxd-table-card']") public WebElement firstResultRow;
}