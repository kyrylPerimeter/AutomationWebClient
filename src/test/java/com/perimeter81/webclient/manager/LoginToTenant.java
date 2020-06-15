package com.perimeter81.webclient.manager;

import com.perimeter81.webclient.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginToTenant extends TestBase {


        public void test() throws InterruptedException {
            session.login("activity", "kyryl+testActivity@perimeter81.com" , "qwertY12345^");

            Assert.assertTrue(isUserLoggedIn());
        }


        public boolean isUserLoggedIn(){

            return isElementPresent(By.xpath("//button[@class='Button_base__3gzB6 Button_outline__3Hjga Button_invert__1seCt Button_small__y6Dha ControlButtons_createButton__1kY8A']"));
        }

        public boolean isElementPresent(By locator){
            return session.driver.findElements(locator).size()>0;
        }

}
