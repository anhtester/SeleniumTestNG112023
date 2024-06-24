package com.anhtester.Bai24_Parameter_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoParameter {

    @Test
    @Parameters({"val1", "val2"})
    public void Sum(@Optional("20") int v1, @Optional("30") int v2) {
        int finalSum = v1 + v2;
        System.out.println("Kết quả là: " + finalSum);
    }

    @Test
    @Parameters({"url", "email", "password"})
    public void login(String v1, String v2, int v3) {
        System.out.println("URL: " + v1);
        System.out.println("Email: " + v2);
        System.out.println("Password: " + v3);
    }

}
