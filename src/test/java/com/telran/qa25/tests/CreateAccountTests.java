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


    @Test(dataProvider = "validUserFromFile",dataProviderClass = DataProviders.class, enabled = true)
    public void signUpFromDataProviderPositiveFromFileTest(User user) throws InterruptedException {

        //fill registration form
        appManager.getUser().fillRegistrationForm(user);

        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(2000);

        //check if user signed up
        logger.info("Login form present. Actual result: " + appManager.getHeader().isLoginFormPresent() + "; expected result: true");

        //updated

        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());

        ///updated
     }


    @Test(dataProvider = "invalidUserFromFile",dataProviderClass = DataProviders.class, enabled = true)
    public void signUpFromDataProviderNegativeFromFileTest(User user) throws InterruptedException {

        //fill registration form
        appManager.getUser().fillRegistrationForm(user);




        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(2000);

        //check if user signed up
        logger.info("Login form present. Actual result: " + appManager.getHeader().isLoginFormPresent() + "; expected result: false");

        Assert.assertFalse(appManager.getHeader().isLoginFormPresent());
     }


     ////////////////////////////////////////
     @Test(dataProvider = "validUser", dataProviderClass = DataProviders.class,enabled = false)
     public void signUpFromDataProviderTest(String fName, String lName,
                                            String email, String password) throws InterruptedException {

         //fill registration form
         appManager.getUser().fillRegistrationForm(new User()
                 .setFirstName(fName)
                 .setSecondName(lName)
                 .setEmail(System.currentTimeMillis() + email)
                 .setPassword(password));
         if(!appManager.getUser().isCheckPolicyMarked()) {
             appManager.getUser().clickCheckPolicy();
         }
         appManager.getUser().clickSubmitForm();

         appManager.getUser().delay(2000);

         //check if user signed up
         logger.info("Login form present. Actual result: " + appManager.getHeader().isLoginFormPresent() + "; expected result: true");

         Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());
     }




//////////////////////////////////////////////////////////
    @Test(enabled = false)
    public void signUpTest() throws InterruptedException {

        //fill registration form
        appManager.getUser().fillRegistrationForm(new User()
                .setFirstName("firstname")
                .setSecondName("secondname")
                .setEmail("yb_mail70@gmail.com")
                .setPassword("J20i12s13"));
        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(2000);

        //check if user signed up
        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());

    }

    @Test(enabled = false)
    public void signUpWithoutPasswordTest() throws InterruptedException {

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

    }

    @Test(enabled = false)
    public void signUpWithoutMailTest() throws InterruptedException {

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

    }

    @Test(enabled = false)
    public void signUpWithWrongDataTest() throws InterruptedException {

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

    }

}
