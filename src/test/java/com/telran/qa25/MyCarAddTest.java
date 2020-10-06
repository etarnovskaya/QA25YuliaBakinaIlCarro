package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCarAddTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        if(isSignUpTabPresentInHeader()){
            clickLoginTabOnHeader();
            delay(1000);
            loginUser("yb_mail10@gmail.com","J20i12s13");
        }
    }

    @Test(enabled = true)
    public void myCarAddPositiveTest(){
        //Let the car work link opening
        System.out.println("Adding car test is started");

        delay(1000);
        click(By.xpath("//ul[@class='header__nav desktop']//li[2]"));

        //Check the correct page is opened
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");
        delay(1000);

        //Fill all the fields with correct details
        type(By.name("country"),"Israel");
        type(By.name("address"),"Netanya, Herzl, 13, 2");
        type(By.name("distance_included"),"500");
        type(By.name("serial_number"), "88888888");
        type(By.name("make"), "Honda");
        type(By.name("model"),"Civic");
        type(By.name("year"),"2020");
        type(By.name("engine"), "HC123456789HC");
        type(By.name("fuel_consumption"),"6.5");
        type(By.name("fuel"),"petrol");
        type(By.name("gear"),"full drive");
        type(By.name("wheels_drive"),"4WD");
        type(By.name("horsepower"), "149");
        type(By.name("torque"),"120");
        type(By.name("doors"),"5");
        type(By.name("seats"),"5");
        type(By.name("car_class"),"C");
        type(By.name("about"),"Very good car");
        type(By.name("features"), "new one, non smoking, navigator, baby chair");
        type(By.name("price_per_day"),"50");

        //upload photo

        //click submit button
        clickSubmitForm();
        System.out.println("The car was added! Adding car test is completed!");

        //logout
        logOut();
        System.out.println("User was logged out!");
        delay(2000);

    }

}
