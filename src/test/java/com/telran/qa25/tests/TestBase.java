package com.telran.qa25.tests;

import com.telran.qa25.helpers.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestBase {

    protected static ApplicationManager appManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp(){
       appManager.init();
    }


    @BeforeMethod
    public void startTest(Method m)
    {
        logger.info("Start test: " + m.getName());

    }

    @AfterSuite(enabled = true)
    public void tearDown() {
         appManager.stop();
    }


    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test: " + m.getName());
        logger.info("======================================================");
    }

}
