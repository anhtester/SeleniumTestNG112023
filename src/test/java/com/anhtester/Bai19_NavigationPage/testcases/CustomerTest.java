package com.anhtester.Bai19_NavigationPage.testcases;

import com.anhtester.Bai19_NavigationPage.pages.CommonPage;
import com.anhtester.Bai19_NavigationPage.pages.CustomerPage;
import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customerPage = dashboardPage.clickMenuCustomer(); //Hàm này nằm bên CommonPage
        customerPage.clickAddNewButton();
        customerPage.enterDataAddNewCustomer("Anh Tester 05062024A1");
        customerPage.checkCustomerDetail("Anh Tester 05062024A1");
    }
}
