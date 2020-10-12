package com.telran.qa25.tests;

import com.telran.qa25.TestBase;
import com.telran.qa25.objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(!appManager.getHeader().isLoginFormPresent()){
            if(appManager.getUser().isUserLoggedIn()){
                appManager.getUser().logOut();
            }
            appManager.getHeader().clickLoginTabOnHeader();
        }
    }

    @Test(enabled = true)
    public void loginRegisteredUserPositiveTest() throws InterruptedException {
        System.out.println("Login test is started");

        //go to login page and log in
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(1000);

        //check if user have logged in
        Assert.assertTrue(appManager.getUser().isUserLoggedIn());
        String email = appManager.getHeader().getEmailTextFromHeader();
        Assert.assertEquals(email,"yb_mail10@gmail.com");

        System.out.println("Login test is completed");

    }

    @Test(enabled = true)
    public void loginUnregisteredUserTest() throws InterruptedException {
        System.out.println("Unregistered user login test is started");

        //go to login page and log in
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail5555555@gmail.com")
                .setPassword("J20i12s13"));

        appManager.getUser().delay(1000);

        //check if the submit button is available
        if(appManager.getUser().checkSubmitButtonIsAvailable()){
             appManager.getUser().clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertFalse(appManager.getUser().isUserLoggedIn());

        System.out.println("Unregistered user login test is completed");

    }

    @Test(enabled = true)
    public void loginUserWithoutPasswordTest() throws InterruptedException {
        System.out.println("User without password login test is started");

        //go to login page and log in
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                );

        appManager.getUser().delay(1000);

        //check if the submit button is available
        if(appManager.getUser().checkSubmitButtonIsAvailable()){
            appManager.getUser().clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertFalse(appManager.getUser().isUserLoggedIn());

        System.out.println("User without password login test is completed");

    }

    @Test(enabled = true)
    public void loginUserWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("User with invalid password login test is started");

        //go to login page and log in
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J3"));

        appManager.getUser().delay(1000);

        //check if the submit button is available
        if(appManager.getUser().checkSubmitButtonIsAvailable()){
            appManager.getUser().clickSubmitForm();
        }else{
            System.out.println("Yalla button is disabled - the registration form was filled incorrect");
        }

        //check if user have logged in
        Assert.assertFalse(appManager.getUser().isUserLoggedIn());

        System.out.println("User with invalid password login test is completed");

    }
}
