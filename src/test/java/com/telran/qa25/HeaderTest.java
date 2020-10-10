package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignUpTabPresentInHeader()){
            logOut();
        }
    }

    @Test(enabled = false)
    public void testHeader() throws InterruptedException {
        System.out.println("Header test is started");

        //Search link
        click(By.xpath("//section[@class='container header']//ul//li[1]"));
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Search", actualResult, "Find your car now!");

        delay(1000);

        //Let the car work link
        click(By.xpath("//section[@class='container header']//ul//li[2]"));
        actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");

        delay(1000);

        //Sign up
        click(By.xpath("//section[@class='container header']//ul//li[4]"));
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Sign up", actualResult, "Registration");

        delay(1000);

        //Login
        click(By.xpath("//section[@class='container header']//ul//li[5]"));
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Log in", actualResult, "Log in");

        delay(1000);

        //ilCarro logo
        click(By.xpath("//section[@class='container header']//img[@alt='logo']"));
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Main page", actualResult, "Find your car now!");

        delay(1000);

        System.out.println("Header test is completed");
    }

}
