package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    //Khai báo driver cục bộ
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    //Khai báo các element dạng đối tượng WebElement
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerPage;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindAll({
            @FindBy(xpath = "//button[normalize-space()='Login']"),
            @FindBy(xpath = "//button[@type='submit123']")
    })
    private WebElement buttonLogin;

    //@FindBy(xpath = "//button[normalize-space()='Login']") private WebElement buttonLogin;

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    private WebElement errorMessage;
    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    private WebElement menuDashboard;

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li"))
    private List<WebElement> listMenu;

    //Hàm xây dựng cho từng class Page
    public LoginPage(WebDriver driver) {
        this.driver = driver; //Nhận giá trị driver từ bên ngoài (BaseTest) khi khởi tạo class này
        //PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, this);
    }

    //Khai báo các element dạng đối tượng By
//    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
//    private By inputEmail = By.xpath("//input[@id='email']");
//    private By inputPassword = By.xpath("//input[@id='password']");
//    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");
//    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");

    public void getListMenu() {
        for (int i = 0; i < listMenu.size(); i++) {
            System.out.println(listMenu.get(i).getText());
        }
    }

    public void loginCRM(String email, String password) {
        driver.get(ConfigData.URL);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void verifyLoginSuccess() {
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(menuDashboard.isDisplayed(), "FAIL. Can not redirect to Dashboard page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/", "FAIL. The current url not match.");
    }

    public void verifyLoginFail(String expectedMessage) {
        WebUI.waitForPageLoaded(driver);
        // Assert.assertTrue(WebUI.checkElementExist(driver, errorMessage), "FAIL. The error message not display.");
        Assert.assertEquals(errorMessage.getText(), expectedMessage, "FAIL. The content of error massge not match.");
    }
}
