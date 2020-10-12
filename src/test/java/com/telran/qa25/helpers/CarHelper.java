package com.telran.qa25.helpers;

import com.telran.qa25.objects.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase {

    public CarHelper(WebDriver wd){
       super(wd);
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
