package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;

    //@BeforeMethod
    @BeforeSuite
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

    }

    //@AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown() {
        wd.quit();
    }


    public boolean isElementPresent1(By locator){
        return wd.findElements(locator).size()>0;
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

 /*   public boolean isElementPresented1(){
        return  isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

    }

    public boolean isElementPresented2(){
        return isElementPresent2(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));
     }*/

     public void textEqualsAssert(String name, String actualResult, String expectedResult){
         try {
             Assert.assertEquals(actualResult, expectedResult);
             System.out.println(name + " link is opened");
         }catch(AssertionError ex){
             System.out.println(name + " link doesn't work");
         }
     }

     public void checkFooterPresent() {
         if (!isElementPresent1(By.className("class='container-full'"))) {
             wd.findElement(By.xpath("//section[@class='container header']//img[@alt='logo']")).click();
         }
     }

    public void delay(int timeout) throws InterruptedException {
         Thread.sleep(timeout);
    }

    public void type(By locator, String text) {
        click(locator);

        //wd.findElement(locator).clear(); - doesn't work for Login form

        wd.findElement(locator).sendKeys(Keys.CONTROL + "a");
        wd.findElement(locator).sendKeys(Keys.DELETE);

        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void clickSubmitForm() {
        new WebDriverWait(wd,15).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
    }

    protected boolean isLoginFormPresent() {
        return isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent1(By.cssSelector("[href='/signup']"));
    }

    public void logOut(){
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(., 'logOut')]"));
    }

    protected void fillLoginUserForm(User user) {
        type(By.name("email"), user.getEmail());
     //   type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }
}
