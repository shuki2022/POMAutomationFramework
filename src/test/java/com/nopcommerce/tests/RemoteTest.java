package com.nopcommerce.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {

    @Test
    public void chromeTest(){
        DesiredCapabilities dc =new DesiredCapabilities();
        dc.setBrowserName("chrome");
        //URL url =new URL("http://localhost:4444/grid/console");
        URL url = null;
        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RemoteWebDriver driver =new RemoteWebDriver(url,dc);
        driver.get("https://demo.nopcommerce.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
