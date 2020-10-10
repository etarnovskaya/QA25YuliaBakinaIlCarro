package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
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
    public void signUpTest() throws InterruptedException {
        System.out.println("Registration test is started");

        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        delay(1000);
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setEmail("yb_mail60@gmail.com")
                .setPassword("J20i12s13"));

        if(!isElementPresent1(By.cssSelector("[id='check_policy'][checked]"))) {
            click(By.cssSelector("#check_policy"));
        }

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

    @Test(enabled = true)
    public void signUpWithoutPasswordTest() throws InterruptedException {
        System.out.println("Negative test 'Without password' is started");

        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        delay(1000);
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setEmail("yb_mail51@gmail.com")
                );

        if(!isElementPresent1(By.cssSelector("[id='check_policy'][checked]"))) {
            click(By.cssSelector("#check_policy"));
        }

        //click submit button
        clickSubmitForm();
        Assert.assertFalse(isLoginFormPresent());
        System.out.println("Registration test is completed");
    }

    @Test(enabled = true)
    public void signUpWithoutMailTest() throws InterruptedException {
        System.out.println("Negative test 'Without mail' is started");

        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        delay(1000);
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                //.setEmail("")
                .setPassword("J20i12s13"));

        if(!isElementPresent1(By.cssSelector("[id='check_policy'][checked]"))) {
            click(By.cssSelector("#check_policy"));
        }

        //click submit button
        clickSubmitForm();
        Assert.assertFalse(isLoginFormPresent());
        System.out.println("Registration test is completed");
    }

    @Test(enabled = true)
    public void signUpWithWrongDataTest() throws InterruptedException {
        System.out.println("Negative test 'Wrong data' is started");

        //click On SignUp button
        click(By.cssSelector("[href='/signup']"));
        delay(1000);
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));

        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("русский")
                .setSecondName("עברית")
                .setEmail("yb_mail1111111@gmail.com")
                .setPassword("J20i12s13"));

        if(!isElementPresent1(By.cssSelector("[id='check_policy'][checked]"))) {
            click(By.cssSelector("#check_policy"));
        }

        //click submit button
        clickSubmitForm();
        Assert.assertFalse(isLoginFormPresent());
        System.out.println("Registration test is completed");
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }


}
