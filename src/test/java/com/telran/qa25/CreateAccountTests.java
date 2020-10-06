package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignUpTabPresentInHeader()){
            logOut();
        }
    }

    @Test(enabled = true)
    public void signUpTest(){
        System.out.println("Registration test is started");

        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        delay(1000);
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        //fill registration form
        type(By.cssSelector("#first_name"),"firstname");
        type(By.cssSelector("#second_name"), "secondname");
        type(By.cssSelector("#email"), "yb_mail42@gmail.com");
        type(By.cssSelector("#password"), "J20i12s13");

        click(By.cssSelector("#check_policy"));

        //check if the submit button is available
        if(!isElementPresent1(By.xpath("//input[@type='submit'][@disabled]"))){
            System.out.println("Yalla button is enabled");
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //click submit button
        clickSubmitForm();
        Assert.assertTrue(isLoginFormPresent());
        System.out.println("Registration test is completed");
    }

}
