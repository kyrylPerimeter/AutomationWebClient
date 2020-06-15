package com.perimeter81.webclient.tests;


import com.perimeter81.webclient.manager.ApplicationManager;
import com.perimeter81.webclient.manager.SessionHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();
    public static SessionHelper session = new SessionHelper();

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
    }

    @AfterSuite
        public void tearDown()   {
        app.stop();
    }
}
