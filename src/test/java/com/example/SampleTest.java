package com.example;


import com.sun.javafx.geom.Edge;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SampleTest {
    @Test

    public void testOpenPerimeterWebSite() {

         // WebDriver webDriver = new SafariDriver();
        WebDriver webDriver = new ChromeDriver();
        //WebDriver webDriver = new EdgeDriver();
        //WebDriver webDriver = new FirefoxDriver();

        webDriver.get("https://www.perimeter81.com/");

        webDriver.quit();

    }




}
