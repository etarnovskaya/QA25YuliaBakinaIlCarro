package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

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
    public void loginRegisteredUserPositiveTest(){
        System.out.println("Login test is started");

        //go to login page and log in
        delay(1000);
        loginUser("yb_mail10@gmail.com","J20i12s13");

        //check if user have logged in
        System.out.println("User logged in: " + isUserLoggedIn());
        System.out.println("Login test is completed");

        //log out
        logOut();
        delay(1000);
    }

}
