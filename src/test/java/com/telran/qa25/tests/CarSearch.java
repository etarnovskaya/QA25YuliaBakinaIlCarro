package com.telran.qa25.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//not used for now
public class CarSearch extends TestBase{

    @BeforeMethod(enabled = false)
    public void ensurePreconditions(){
        if(!appManager.getHeader().isSignUpTabPresentInHeader()){
            appManager.getUser().logOut();
        }

        appManager.getHeader().clickSearchTabOnHeader();

    }

    @Test(enabled = false)
    public void testCarSearchByFiltersPositive() throws InterruptedException {
        appManager.getHeader().delay(1000);

        appManager.getHeader().click(By.cssSelector("[class='search-sidebar__tab tab-second']"));
        appManager.getHeader().delay(1000);



    }

}
