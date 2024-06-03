package com.anhtester.Bai18_PageFactory.testcases;

import com.anhtester.Bai18_PageFactory.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        loginPage.getListMenu();
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 3)
    public void testLoginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 4)
    public void testLoginFailWithEmailNull(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("", "123");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }
}
