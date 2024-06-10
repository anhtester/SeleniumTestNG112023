package com.anhtester.Bai20_21_ThucHanhPageObject.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage extends CommonPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    //Elements
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@placeholder='Search...']");
    private By firstItemCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVat = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By selectGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputGroups = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    private By selectLanguage = By.xpath("//button[@data-id='default_language']");
    private By itemVietnam = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZip = By.xpath("//input[@id='zip']");
    private By selectCountry = By.xpath("//button[@data-id='country']");
    private By inputCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By alertMessage = By.xpath("//span[@class='alert-title']");
    private By totalCustomers = By.xpath("//span[text()='Total Customers']/preceding-sibling::span");

    //Hàm xử lý cho trang Customer
    public void clickAddNewButton() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public String getTotalCustomers(){
        WebUI.waitForPageLoaded(driver);
        return driver.findElement(totalCustomers).getText();
    }

    public void selectLanguage(String languageName) {
        WebUI.clickElement(selectLanguage);
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + languageName + "']"));
    }

    public void enterDataAddNewCustomer(String customerName) {
        WebUI.setText(inputCompany, customerName);
        WebUI.setText(inputVat, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://anhtester.com");
        WebUI.clickElement(selectGroups);
        WebUI.sleep(1);
        WebUI.setText(inputGroups, "VIP");
        WebUI.sleep(1);
        WebUI.setKey(inputGroups, Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(selectGroups);
        selectLanguage("Vietnamese");
        WebUI.sleep(1);

        WebUI.setText(inputAddress, "Can Tho");
        WebUI.setText(inputCity, "Can Tho");
        WebUI.setText(inputState, "Can Tho");
        WebUI.setText(inputZip, "12345");

        WebUI.clickElement(selectCountry);
        WebUI.sleep(1);
        WebUI.setText(inputCountry, "Vietnam");
        WebUI.sleep(1);
        WebUI.setKey(selectCountry, Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(buttonSave);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(driver, alertMessage), "\uD83D\uDC1E FAIL!! The alert message success not display.");
        Assert.assertEquals(driver.findElement(alertMessage).getText().trim(), "Customer added successfully.", "\uD83D\uDC1E FAIL!! The content of alert message not match.");
    }

    public void checkCustomerInTableList(String customerName) {
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(menuCustomers);
        WebUI.waitForPageLoaded(driver);
        WebUI.setText(inputSearchCustomer, customerName);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);

        //Check customer name display in table
        Assert.assertTrue(WebUI.checkElementExist(driver, firstItemCustomerName), "\uD83D\uDC1E FAIL!! The customer name not display in table.");
        Assert.assertEquals(driver.findElement(firstItemCustomerName).getText(), customerName, "\uD83D\uDC1E FAILL!! The customer name not match.");
    }

    public void checkCustomerDetail(String customerName){
        //Check cutsomer detail in Customer Detail page
        WebUI.waitForPageLoaded(driver);
        driver.findElement(firstItemCustomerName).click();
        WebUI.waitForPageLoaded(driver);
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), customerName);
        Assert.assertEquals(driver.findElement(inputVat).getAttribute("value"), "10", "FAIL!! The VAT of customer not match.");
        Assert.assertEquals(driver.findElement(inputPhone).getAttribute("value"), "123456");
        Assert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "https://anhtester.com");
        Assert.assertEquals(driver.findElement(selectGroups).getAttribute("title"), "VIP", "FAIL!! The Group of customer not match.");
        Assert.assertEquals(driver.findElement(selectLanguage).getAttribute("title"), "Vietnamese", "FAIL!! The Language of customer not match.");
        Assert.assertEquals(driver.findElement(inputAddress).getAttribute("value"), "Can Tho");
    }
}
