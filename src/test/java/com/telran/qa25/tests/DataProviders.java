package com.telran.qa25.tests;

import com.telran.qa25.objects.Car;
import com.telran.qa25.objects.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    /////USER REGISTRATION
    @DataProvider
    public Iterator<Object[]>validUserFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/DataProviderUserRegistration.csv")));

        return readUsersFromFile(reader);
    }

    @DataProvider
    public Iterator<Object[]>invalidUserFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/DataProviderInvalidUserRegistration.csv")));

        return readUsersFromFile(reader);
    }

    private Iterator<Object[]> readUsersFromFile(BufferedReader reader) throws IOException {
        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(";");

            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setSecondName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }


    /////CAR

    @DataProvider
    public Iterator<Object[]>validCarFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/DataProviderAddCar.csv")));

        return readCarsFromFile(reader);
    }

    @DataProvider
    public Iterator<Object[]>invalidCarFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/DataProviderInvalidCar.csv")));

        return readCarsFromFile(reader);
    }


    private Iterator<Object[]> readCarsFromFile(BufferedReader reader) throws IOException {
        List<Object[]> list = new ArrayList<>();
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(";");

            list.add(new Object[]{new Car()
                    .setCountry(split[0])
                    .setAddress(split[1])
                    .setDistance(split[2])
                    .setSerialNumber(split[3])
                    .setMake(split[4])
                    .setModel(split[5])
                    .setYear(split[6])
                    .setEngine(split[7])
                    .setFurlConsumption(split[8])
                    .setFuelType(split[9])
                    .setGear(split[10])
                    .setWheelsDrive(split[11])
                    .setHorsePower(split[12])
                    .setTorque(split[13])
                    .setDoors(split[14])
                    .setSeats(split[15])
                    .setCarClass(split[16])
                    .setAbout(split[17])
                    .setFeatures(split[18])
                    .setPricePerDay(split[19])});

            line = reader.readLine();
        }

        return list.iterator();
    }

    //////////////////////
    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName","lName","lName@gmail.com","J20i12s13"});
        list.add(new Object[]{"fName1","lName1","lName@gmail.com","J20i12s13"});
        list.add(new Object[]{"fName2","lName2","lName@gmail.com",""});

        return list.iterator();
    }

}
