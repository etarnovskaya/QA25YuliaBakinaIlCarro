package com.telran.qa25.tests;

import com.telran.qa25.objects.Car;
import com.telran.qa25.objects.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyCarAddTest extends TestBase {

    @BeforeMethod(enabled = true)
    public void ensurePreconditions(){

        if(appManager.getUser().isUserLoggedIn()){
            appManager.getUser().logOut();
        }
    }

   @Test(enabled = true)
    public void myCarAddByLoggedInUserPositiveTest() throws InterruptedException {
       System.out.println("Adding car by logged in user test is started");

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                    .setEmail("yb_mail10@gmail.com")
                    .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("129-11-735").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getCar().clickSubmitForm();

       appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Adding car by logged in user test is completed!");

    }

    @Test(enabled = true)
    public void myCarAddUserLogoutPositiveTest() throws InterruptedException {
        System.out.println("Adding car by not logged in user test is started");

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("777-22-130").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(appManager.getHeader().isLoginFormPresent());

        System.out.println("Adding car by not logged in user test is completed!");

    }

    @Test(enabled = true)
    public void myCarAddTheSameSerialNumberTest() throws InterruptedException {
        System.out.println("Adding car with existing serial number test is started");

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car()
                .setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("123-11-777").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        appManager.getCar().delay(2000);

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Adding car with existing serial number test is completed!");

    }

    @Test(enabled = true)
    public void myCarAddWithoutDoorsTest() throws InterruptedException {
        System.out.println("Adding car without doors info test is started");

        //Login user
        appManager.getHeader().clickLoginTabOnHeader();
        appManager.getUser().fillLoginUserForm(new User()
                .setEmail("yb_mail10@gmail.com")
                .setPassword("J20i12s13"));
        appManager.getCar().clickSubmitForm();

        appManager.getCar().delay(1000);

        //Let the car work link opening
        appManager.getHeader().clickAddCarTabOnHeader();
        appManager.getHeader().isAddCarFormPresent();

        //Fill all the fields with correct details
        appManager.getCar().fillCarAddingForm(new Car().setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("444-00-999").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        appManager.getUser().clickSubmitForm();

        //check the car was added
        //Don't know how to read status and message from browser console log
        Assert.assertTrue(!appManager.getHeader().isLoginFormPresent());

        System.out.println("Adding car without doors info test is completed!");
    }

}
