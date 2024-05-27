package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.DashboardPage;
import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckSectionQuickStatisticsDisplay(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatistics();
    }

    @Test(priority = 2)
    public void testCheckTotalSectionQuickStatistics(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.checkTotalInvoicesAwaitingPayment();
        dashboardPage.checkTotalConvertedLeads();
        dashboardPage.checkTotalProjectsInProgress();
        dashboardPage.checkTotalTasksNotFinished();
    }
}
