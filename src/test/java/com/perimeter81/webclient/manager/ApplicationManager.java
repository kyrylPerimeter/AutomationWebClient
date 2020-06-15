package com.perimeter81.webclient.manager;

import com.perimeter81.webclient.tests.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager extends TestBase {

    public void init() throws InterruptedException {
    session.driver = new ChromeDriver();
    session.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    session.driver.manage().window().maximize();
    session.openUrl("https://www.perimeter81.com/");
    session.login("dnspremium", "kyryl+test@perimeter81.com", "qwertY12345^");
    }

    public void stop() {
        session.driver.quit();
    }
}
