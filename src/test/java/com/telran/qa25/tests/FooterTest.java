package com.telran.qa25.tests;

import com.telran.qa25.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

    }


    @Test(enabled = true)
    public void testFooter() {
        System.out.println("Footer test is started");

        //Search link
        appManager.getFooter().makeFooterPresent();
        appManager.getFooter().clickSearchLinkOnFooter();
        appManager.getHeader().isSearchFormPresent();

        //Let the car work link
        appManager.getFooter().makeFooterPresent();
        appManager.getFooter().clickAddCarLinkOnFooter();
        appManager.getHeader().isAddCarFormPresent();

        //ilCarro logo
        appManager.getFooter().makeFooterPresent();
        appManager.getFooter().clickLogoIconOnFooter();
        appManager.getHeader().isMainPagePresent();

        System.out.println("Footer test is completed");

    }


}
