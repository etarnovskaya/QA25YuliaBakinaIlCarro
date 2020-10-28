package com.telran.qa25.tests;

import com.telran.qa25.objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @DataProvider
    public Iterator<Object[]>validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName","lName","lName@gmail.com","J20i12s13"});
        list.add(new Object[]{"fName1","lName1","lName@gmail.com","J20i12s13"});
        list.add(new Object[]{"fName2","lName2","lName@gmail.com",""});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validUserFromFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/DataProvider.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setSecondName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions(){
        if(!appManager.getHeader().isSignUpTabPresentInHeader()){
            appManager.getUser().logOut();
        }
        appManager.getHeader().clickSignupTabOnHeader();
    }

    @Test(dataProvider = "validUser" ,enabled = true)
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

        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());
     }

    @Test(dataProvider = "validUserFromFile" ,enabled = true)
    public void signUpFromDataProviderFileTest(User user) throws InterruptedException {

        //fill registration form
        appManager.getUser().fillRegistrationForm(user);

        if(!appManager.getUser().isCheckPolicyMarked()) {
            appManager.getUser().clickCheckPolicy();
        }
        appManager.getUser().clickSubmitForm();

        appManager.getUser().delay(2000);

        //check if user signed up
        logger.info("Login form present. Actual result: " + appManager.getHeader().isLoginFormPresent() + "; expected result: true");

        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());
     }

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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

    @Test(enabled = true)
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
