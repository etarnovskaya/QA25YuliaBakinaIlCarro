package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;

    //before
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    //tests
    @Test
    public void openSite(){
        System.out.println("Site is opened!");

        int num = (int) (Math.random()*100);
        String firstName = "AT_Name" + num;
        String secondName = "AT_SecondName" + num;
        String email = secondName + "@gmail.com";
        String password = "Qwer1234";

        signupTest(firstName, secondName, email, password);

        loginTest(email,password);

        logutTest();

    }

    @AfterMethod
   public void tearDown(){
        wd.quit(); // quit from the browser. Does not matter how many tabs are opened
    }


    public void signupTest(String firstName, String secondName, String email, String password){
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/signup");
        wd.findElement(By.name("first_name")).click();
        wd.findElement(By.name("first_name")).sendKeys(firstName);
        wd.findElement(By.name("second_name")).click();
        wd.findElement(By.name("second_name")).sendKeys(secondName);
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).sendKeys(password);
        wd.findElement(By.name("check_policy")).click();

        delay(2000);

        wd.findElement(By.className("yalla_yalla__1Jxk6")).click();
        System.out.println("User: " + firstName + " " + secondName + " Email: " + email + " is now signed up!");

        delay(2000);
    }

    public void loginTest(String username, String password){
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/login");
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys(username);
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).sendKeys(password);

        delay(2000);

        wd.findElement(By.className("style_yalla__2DbRH")).click();
        System.out.println("User: " + username + " is now logged in!");

        delay(2000);
    }

    public void logutTest(){
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/login");
        System.out.println("User is now logged out!");
        delay(2000);
    }

    public void delay(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
