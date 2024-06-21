package com.anhtester.Bai22_23_VietHamChungWebUI.testcases;

import com.anhtester.Bai22_23_VietHamChungWebUI.pages.CustomerPage;
import com.anhtester.Bai22_23_VietHamChungWebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_VietHamChungWebUI.pages.LoginPage;
import com.anhtester.Bai22_23_VietHamChungWebUI.pages.ProjectPage;
import com.anhtester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProjectPage projectPage;

    @Test
    public void testAddNewCustomer() {

        String CUSTOMER_NAME = "Anh Tester 21062024A1";

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        customerPage = dashboardPage.clickMenuCustomer(); //Hàm này nằm bên CommonPage

        int totalCustomersBefore = Integer.parseInt(customerPage.getTotalCustomers());
        System.out.println("\uD83C\uDF40 Total Customers Before: " + totalCustomersBefore);
        customerPage.clickAddNewButton();
        customerPage.enterDataAddNewCustomer(CUSTOMER_NAME);
        customerPage.checkCustomerInTableList(CUSTOMER_NAME);
        System.out.println("\uD83C\uDF40 Total Customers After: " + customerPage.getTotalCustomers());
        Assert.assertEquals(customerPage.getTotalCustomers(), String.valueOf(totalCustomersBefore + 1), "FAIL!! The Total Customers in Customer Page not match.");
        customerPage.checkCustomerDetail(CUSTOMER_NAME);
        projectPage = customerPage.clickMenuProjects();
        projectPage.clickAddNewProject();
        projectPage.checkCustomerDisplayInSelectSection(CUSTOMER_NAME);
    }
}
