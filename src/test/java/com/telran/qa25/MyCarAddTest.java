package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyCarAddTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if(isSignUpTabPresentInHeader()){
            clickLoginTabOnHeader();
            delay(1000);
            fillLoginUserForm(new User()
                    .setEmail("yb_mail10@gmail.com")
                    .setPassword("J20i12s13"));
            clickSubmitForm();
        }
    }

    @Test(enabled = true)
    public void myCarAddPositiveTest() throws InterruptedException {
        //Let the car work link opening
        System.out.println("Adding car test is started");
        delay(1000);
        click(By.xpath("//ul[@class='header__nav desktop']//li[2]"));

        //Check the correct page is opened
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");
        delay(1000);

        //Fill all the fields with correct details
        fillCarAddingForm(new Car().setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("777-00-777").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        clickSubmitForm();

        //check the car was added
        //Don't know how to read status and message from browser console log
        System.out.println("Adding car test is completed!");

        //logout
        logOut();
        System.out.println("User was logged out!");
        delay(2000);

    }

    @Test(enabled = true)
    public void myCarAddTheSameSerialNumberTest() throws InterruptedException {
        //Let the car work link opening
        System.out.println("Adding car test is started");
        delay(1000);
        click(By.xpath("//ul[@class='header__nav desktop']//li[2]"));

        //Check the correct page is opened
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");
        delay(1000);

        //Fill all the fields with correct details
        fillCarAddingForm(new Car().setCountry("Israel").setAddress("Netanya, Herzl, 13, 2").setDistance("500")
                .setSerialNumber("777-00-777").setMake("Honda").setModel("Civic").setYear("2015")
                .setEngine("HC123456789HC").setFurlConsumption("6.5").setFuelType("petrol")
                .setGear("full drive").setWheelsDrive("4WD").setHorsePower("149").setTorque("120")
                .setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("Very good car").setFeatures("new one, non smoking, navigator, baby chair").setPricePerDay("55"));

        //upload photo

        //click submit button
        clickSubmitForm();

        //check the car was added
        // Don't know how to read status and message from browser console log
        System.out.println("Adding car test is completed!");

        //logout
        logOut();
        System.out.println("User was logged out!");
        delay(2000);

    }

    public void fillCarAddingForm(Car car) {
        type(By.name("country"), car.getCountry());
        type(By.name("address"), car.getAddress());
        type(By.name("distance_included"), car.getDistance());
        type(By.name("serial_number"), car.getSerialNumber());
        type(By.name("make"), car.getMake());
        type(By.name("model"), car.getModel());
        type(By.name("year"), car.getYear());
        type(By.name("engine"), car.getEngine());
        type(By.name("fuel_consumption"), car.getFurlConsumption());
        type(By.name("fuel"), car.getFuelType());
        type(By.name("gear"), car.getGear());
        type(By.name("wheels_drive"), car.getWheelsDrive());
        type(By.name("horsepower"), car.getHorsePower());
        type(By.name("torque"), car.getTorque());
        type(By.name("doors"), car.getDoors());
        type(By.name("seats"), car.getSeats());
        type(By.name("car_class"), car.getCarClass());
        type(By.name("about"), car.getAbout());
        type(By.name("features"), car.getFeatures());
        type(By.name("price_per_day"), car.getPricePerDay());
    }

}
