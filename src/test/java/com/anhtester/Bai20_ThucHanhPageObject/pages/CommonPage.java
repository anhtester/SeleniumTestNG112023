package com.anhtester.Bai20_ThucHanhPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    private WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By itemNotifications = By.xpath("//a[contains(@class,'notifications-icon')]");

    public DashboardPage clickMenuDashboard(){
        driver.findElement(menuDashboard).click();

        return new DashboardPage(driver);
    }

    public CustomerPage clickMenuCustomer(){
        driver.findElement(menuCustomers).click();

        return new CustomerPage(driver);
    }

}
