package com.anhtester.Bai16_ThucHanh;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginSuccess(){

        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(ConfigData.EMAIL);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ConfigData.PASSWORD);

        WebUI.waitForElementToBeClickable(driver, By.xpath("//button[normalize-space()='Login']"));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//li[@class='icon header-user-profile']"));

        System.out.println(WebUI.checkElementExist(driver, By.xpath("//li[@class='icon header-user-profile']")));
        System.out.println(driver.findElement(By.xpath("//li[@class='icon header-user-profile']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='icon header-user-profile']")).isDisplayed());
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("user1@example.com");

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");

        WebUI.waitForElementToBeClickable(driver, By.xpath("//button[normalize-space()='Login']"));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//div[@class='text-center alert alert-danger']"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText(), "Invalid email or password", "The content of error message not match.");
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        driver.get(ConfigData.URL);
        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='password']"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");

        WebUI.waitForElementToBeClickable(driver, By.xpath("//button[normalize-space()='Login']"));
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebUI.waitForPageLoaded(driver);

        WebUI.waitForElementVisible(driver, By.xpath("//div[@class='text-center alert alert-danger']"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-center alert alert-danger']")).getText(), "Invalid email or password", "The content of error message not match.");
    }
}
