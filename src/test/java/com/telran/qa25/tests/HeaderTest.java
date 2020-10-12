package com.telran.qa25.tests;

import com.telran.qa25.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        if(!appManager.getHeader().isSignUpTabPresentInHeader()){
            appManager.getUser().logOut();
        }
    }

    @Test(enabled = true)
    public void testHeader() throws InterruptedException {
        System.out.println("Header test is started");

        //Search link
        appManager.getHeader().clickSearchTabOnHeader();
        appManager.getHeader().isSearchFormPresent();

        appManager.getHeader().delay(1000);

        //Let the car work link
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        appManager.getHeader().delay(1000);

        //Sign up
        appManager.getHeader().clickSignupTabOnHeader();
        appManager.getHeader().isSignUpFormPresent();

        appManager.getHeader().delay(1000);

        //Login
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getHeader().isLoginFormPresent();

        appManager.getHeader().delay(1000);

        //ilCarro logo
        appManager.getHeader().clickLogoIconOnHeader();
        appManager.getHeader().isMainPagePresent();

        appManager.getHeader().delay(1000);

        System.out.println("Header test is completed");
    }

}
