package com.telran.qa25.tests;

import com.telran.qa25.helpers.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {

    protected static ApplicationManager appManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

//    Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){
        appManager.init();
    }

    @BeforeMethod
    public void startTest(Method m)
    {
        logger.info("Start test: " + m.getName());
        logger.info("======================================================");

    }

    @AfterSuite(enabled = true)
    public void tearDown() {
        appManager.stop();
    }

    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test: " + m.getName());
    }

}
