package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isLoginFormPresent()){
            if(isUserLoggedIn()){
                logOut();
            }
            clickLoginTabOnHeader();
        }
    }

    @Test(enabled = true)
    public void loginRegisteredUserPositiveTest() throws InterruptedException {
        System.out.println("Login test is started");

        //go to login page and log in
        fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));

        //check if the submit button is available
        if(!isElementPresent1(By.xpath("//input[@type='submit'][@disabled]"))){
            System.out.println("Yalla button is enabled");
            clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertTrue(isUserLoggedIn());
        String email = wd.findElement(By.cssSelector("[href='/account']")).getText();
        Assert.assertEquals(email,"yb_mail10@gmail.com");
        System.out.println("User logged in: " + email);
        System.out.println("Login test is completed");

        //log out
        logOut();
    }

    @Test(enabled = true)
    public void loginUnregisteredUserTest() throws InterruptedException {
        System.out.println("Unregistered user login test is started");

        //go to login page and log in
        fillLoginUserForm(new User()
                .setEmail("yb_mail5555555@gmail.com")
                .setPassword("J20i12s13"));

        //check if the submit button is available
        if(!isElementPresent1(By.xpath("//input[@type='submit'][@disabled]"))){
            System.out.println("Yalla button is enabled");
            clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertFalse(isUserLoggedIn());
        System.out.println("Login test is completed");

    }

    @Test(enabled = true)
    public void loginUserWithoutPasswordTest() throws InterruptedException {
        System.out.println("User without password login test is started");

        //go to login page and log in
        fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                );

        //check if the submit button is available
        if(!isElementPresent1(By.xpath("//input[@type='submit'][@disabled]"))){
            System.out.println("Yalla button is enabled");
            clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertFalse(isUserLoggedIn());
        System.out.println("Login test is completed");

    }
}
