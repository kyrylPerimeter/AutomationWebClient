package com.perimeter81.webclient.manager;

import com.perimeter81.webclient.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class SessionHelper extends TestBase {

    public WebDriver driver;



    public static void waitInMilliSeconds(Long milliSeconds){
        long time = System.currentTimeMillis();
        long stopTime = time + milliSeconds;
        while (time < stopTime){
            time = System.currentTimeMillis();
        }
    }

    public void openUrl(String url)  {
        driver.get(url);
    }

    public void login(String tenant, String email, String password) throws InterruptedException {
        click(By.xpath("//a[@class='rootLink item-signin']"));
        type(By.xpath("//input[@placeholder='your-company-name']"), tenant);
        click(By.xpath("//button[@class='Button_base__3gzB6 Button_primary__Pi7MA Button_block__2_13t']"));
        type(By.xpath("//input[@id='1-email']"), email);
        type(By.xpath("//input[@placeholder='your password']"), password);
        click(By.xpath("//span[@class='auth0-label-submit']"));
        Thread.sleep(2000);
    }


    public boolean ifElementExist(By locator){
        boolean present;
        try {
            driver.findElement(locator);
           return present = true;
        } catch (NoSuchElementException e) {
           return present = false;
        }
    }

    public void type(By locator, String text) {
        click(locator);
        WebElement clear = driver.findElement(locator);
        clear.clear();
        clear.sendKeys(text);

        //clear.sendKeys(Keys.chord(Keys.COMMAND, "a"), text);
    }

    public  void waitPresenceElement(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public  void click(By locator) {
        waitPresenceElement(locator, 10);
        driver.findElement(locator).click();
    }

    public String findElemetnReturnString(By locator){
        WebElement value = driver.findElement(locator);
        String str = value.getText();
        return str;
    }


    public boolean myCurrentPage(String url) throws InterruptedException {

        Thread.sleep(5000);
        String currentUrl = session.driver.getCurrentUrl();


        if(currentUrl.equals(url)){
            System.out.println("==");
            return true;
        }else{
            session.driver.get(url);
            System.out.println("!=");
            return false;
        }


    }
}
