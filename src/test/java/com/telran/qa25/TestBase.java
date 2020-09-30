package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    //before
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @AfterMethod(enabled = false)
   public void tearDown() {
        wd.quit();
    }

    public boolean isElementPresent1(By locator){
        return wd.findElements(locator).size() > 0;
    }

    public boolean isElementPresent2(By locator){
        try {
            wd.findElement(locator);
            return true;
        }
        catch(NoSuchElementException ex)
        {
            return false;
        }
    }

    public boolean isElementPresented1(){
        return  isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

    }

    public boolean isElementPresented2(){
        return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
     }
}
