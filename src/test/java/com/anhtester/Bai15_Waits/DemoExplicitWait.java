package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {
    WebDriver driver;

    @Test(priority = 1)
    public void demoExplicitWait1() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://hrm.anhtester.com/");
        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Projects')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add New']")));
        driver.findElement(By.xpath("//a[normalize-space()='Add New']")).click();

        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Anh Tester Demo");

        Thread.sleep(2000);
        driver.quit();
    }
}
