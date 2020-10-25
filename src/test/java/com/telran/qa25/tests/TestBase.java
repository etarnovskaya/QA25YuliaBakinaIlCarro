package com.telran.qa25.tests;

import com.telran.qa25.helpers.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    protected static ApplicationManager appManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp(){
        appManager.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        appManager.stop();
    }

}
