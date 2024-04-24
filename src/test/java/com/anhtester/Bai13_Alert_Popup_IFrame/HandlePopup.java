package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopup extends BaseTest {
    @Test
    public void demoOpenTab() {
        driver.get("https://anhtester.com");
        sleep(2);
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://google.com");

        sleep(2);
    }

    @Test
    public void demoOpenWindow() {
        driver.get("https://anhtester.com");
        sleep(2);
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://google.com");

        sleep(3);
    }

    @Test
    public void demoNotSwitchToTab() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);
        //Sau khi chuyển hướng sang Tab mới thì getText cái element nào đó
        System.out.println(driver.findElement(By.xpath("(//span[normalize-space()='See more on Facebook'])[1]")).getText());
        sleep(1);
    }

    @Test
    public void testSwitchToPopupWithForLoop() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                sleep(1);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                sleep(1);
                //Sau khi chuyển hướng sang Tab mới thì getText cái element nào đó
                System.out.println(driver.findElement(By.xpath("(//span[normalize-space()='See more on Facebook'])[1]")).getText());
                sleep(1);

                // Tắt cái Tab Window mới.
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }

    @Test
    public void testSwitchToPopupWithPosition() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(2);
        driver.findElement(By.xpath("//a[normalize-space()='Like us On Facebook']")).click();
        sleep(2);

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println("Cửa sổ thứ 1: " + MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Chuyển hướng đến cửa sổ theo vị trí cụ thể
        String firstWindow = (String) windows.toArray()[0]; //Cửa sổ đầu
        System.out.println("Cửa sổ thứ 1: " + firstWindow);
        String secondWindow = (String) windows.toArray()[1]; //Cửa sổ thứ hai
        System.out.println("Cửa sổ thứ 2: " + secondWindow);

        //Chuyển hướng đến cửa sổ thứ 2
        driver.switchTo().window(secondWindow);
        sleep(1);
        System.out.println("Đã chuyển đến Tab Window mới");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        sleep(1);
        System.out.println(driver.findElement(By.xpath("(//span[normalize-space()='See more on Facebook'])[1]")).getText());
        sleep(1);
        //Tắt cái cửa sổ thứ 2
        driver.close();

        //Chuyển hướng về lại cửa sổ ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
}
