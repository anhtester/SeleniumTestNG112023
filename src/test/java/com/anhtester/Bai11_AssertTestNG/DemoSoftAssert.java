package com.anhtester.Bai11_AssertTestNG;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @Test(priority = 1)
    public void testCheckPageTitle() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();

        //Soft Assert
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(originalTitle, expectedTitle, "Tiêu đề trang không đúng.");

        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='btn-login']")).isDisplayed(), "Nút Login không tồn tại.");
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();

        String headerLogin = driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText();
        System.out.println(headerLogin);

        softAssert.assertEquals(headerLogin, "Login123", "Tiêu đề trang Login không đúng.");

        //Gọi assertAll() thì mới thống kê được kết quả phía trên
        softAssert.assertAll();
    }
}
