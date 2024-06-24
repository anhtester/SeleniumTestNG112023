package com.anhtester.Bai24_Parameter_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter2 {

    @Test
    @Parameters({"val1", "val2"})
    public void Sum(@Optional("20") int v1, @Optional("30") int v2) {
        int finalSum = v1 - v2;
        System.out.println("Kết quả là: " + finalSum);
    }

}
