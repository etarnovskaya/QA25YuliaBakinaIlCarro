package com.telran.qa25.tests;

import com.telran.qa25.objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(!appManager.getHeader().isSignUpTabPresentInHeader()){
            appManager.getUser().logOut();
        }
        appManager.getHeader().clickSignupTabOnHeader();
    }

    @Test(enabled = true)
    public void signUpTest() throws InterruptedException {
        System.out.println("Registration test is started");

        //fill registration form
        appManager.getUser().fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setEmail("yb_mail65@gmail.com")
                .setPassword("J20i12s13"));
        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(2000);

        //check if user signed up
        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());

        System.out.println("Registration test is completed");
    }

    @Test(enabled = true)
    public void signUpWithoutPasswordTest() throws InterruptedException {

        System.out.println("Negative test 'Without password' is started");

        //fill registration form
        appManager.getUser().fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setEmail("yb_mail100@gmail.com")
                );
        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(1000);

        //check if user signed up
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Registration test 'Without password' is completed");
    }

    @Test(enabled = true)
    public void signUpWithoutMailTest() throws InterruptedException {
        System.out.println("Negative test 'Without email' is started");

        //fill registration form
        appManager.getUser().fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setPassword("J20i112s13")
        );
        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(1000);

        //check if user signed up
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Registration test 'Without email' is completed");

    }

    @Test(enabled = true)
    public void signUpWithWrongDataTest() throws InterruptedException {

        System.out.println("Negative test 'Wrong data' is started");

        //fill registration form
        appManager.getUser().fillRegistrationForm(new User()
                .setFirstName("русский")
                .setSecondName("עברית")
                .setEmail("yb_mail1111111@gmail.com")
                .setPassword("J20i12s13"));

        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(1000);

        //check if user signed up
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Registration test 'Wrong data' is completed");
    }

}
