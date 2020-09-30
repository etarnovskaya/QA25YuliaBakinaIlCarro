package com.telran.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{
    //WebDriver wd;

    //tests
    @Test
    public void openSite(){
        System.out.println("Site is opened!");

        wd.findElement(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

        System.out.println("1. Find cars: " + isElementPresented1());
        System.out.println("2. Find cars: " + isElementPresented2());

/*        int num = (int) (Math.random()*100);
        String firstName = "AT_Name" + num;
        String secondName = "AT_SecondName" + num;
        String email = secondName + "@gmail.com";
        String password = "Qwer1234";

        signupTest(firstName, secondName, email, password);

        loginTest(email,password);

        logOut();*/

    }

    /*  public void signupTest(String firstName, String secondName, String email, String password){
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

    public void logOut(){
 //       wd.get("https://ilcarro-dev-v1.firebaseapp.com/login");
        wd.findElement(By.cssSelector("[href='/login']")).click();
        System.out.println("User is now logged out!");
        delay(2000);
    }

    public void delay(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

}
