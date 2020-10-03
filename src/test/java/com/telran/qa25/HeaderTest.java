package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent1(By.cssSelector("[href='/signup']"))){
            wd.findElement(By.xpath("//a[contains(., 'logOut')]")).click();
        }
    }

    @Test
    public void testHeader(){
        System.out.println("Header test is started");

        //Search link
        wd.findElement(By.xpath("//section[@class='container header']//ul//li[1]")).click();
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Search", actualResult, "Find your car now!");

        delay(2000);

        //Let the car work link
        wd.findElement(By.xpath("//section[@class='container header']//ul//li[2]")).click();
        actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");

        delay(2000);

        //Sign up
        wd.findElement(By.xpath("//section[@class='container header']//ul//li[4]")).click();
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Sign up", actualResult, "Registration");

        delay(2000);

        //Login
        wd.findElement(By.xpath("//section[@class='container header']//ul//li[5]")).click();
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Log in", actualResult, "Log in");

        delay(2000);

        //ilCarro logo
        wd.findElement(By.xpath("//section[@class='container header']//img[@alt='logo']")).click();
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Main page", actualResult, "Find your car now!");

        delay(2000);

        System.out.println("Header test is completed");
    }

}
