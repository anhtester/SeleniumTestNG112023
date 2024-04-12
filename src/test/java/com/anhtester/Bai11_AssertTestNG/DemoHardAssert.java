package com.anhtester.Bai11_AssertTestNG;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {
    @Test(priority = 1)
    public void testCheckPageTitle() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation Testing";
        String originalTitle = driver.getTitle();

        //Hard Assert
        Assert.assertEquals(originalTitle, expectedTitle, "Tiêu đề trang không đúng.");

        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='btn-login']")).isDisplayed(), "Nút Login không tồn tại.");

        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        String headerLogin = driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText();
        System.out.println(headerLogin);

        Assert.assertEquals(headerLogin, "Login123", "Tiêu đề trang Login không đúng.");

    }
}
