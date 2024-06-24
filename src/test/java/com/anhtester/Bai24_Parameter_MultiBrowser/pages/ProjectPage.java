package com.anhtester.Bai24_Parameter_MultiBrowser.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProjectPage extends CommonPage {
    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By headerPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By buttonAddNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By selectCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div//input");
    private By itemCustomerName = By.xpath("//span[@class='text']");

    public void clickAddNewProject() {
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonAddNewProject);
    }

    public void checkCustomerDisplayInSelectSection(String customerName) {
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(selectCustomer);
        WebUI.sleep(1);
        WebUI.setText(inputSearchCustomer, customerName);
        WebUI.sleep(1);
        String itemCustomer = driver.findElement(itemCustomerName).getText();
        System.out.println("Customer in Select: " + itemCustomer);
        Assert.assertEquals(itemCustomer, customerName, "FAIL!! The Customer not display in Project.");
    }
}
