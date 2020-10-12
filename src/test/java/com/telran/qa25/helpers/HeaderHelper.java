package com.telran.qa25.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver wd){
        super(wd);
    }

    //click on header methods
    public void clickSearchTabOnHeader() {
        click(By.xpath("//section[@class='container header']//ul//li[1]"));
    }

    public void clickAddCarTabOnHeader() {
       click(By.xpath("//section[@class='container header']//ul//li[2]"));
    }

    public void clickSignupTabOnHeader() {
        click(By.xpath("//section[@class='container header']//ul//li[4]"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    //check presenting pages methods
    public boolean isMainPagePresent(){
        return isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent1(By.cssSelector("[href='/signup']"));
    }

    public boolean isSearchFormPresent(){
        return isElementPresent1(By.cssSelector(".main-search__sidebar"));
    }

    public boolean isAddCarFormPresent(){
        return isElementPresent1(By.cssSelector("[class='let-carwork-style_lets_car_form__2fYnX']"));

    }

    public boolean isSignUpFormPresent() {
        return isElementPresent1(By.cssSelector("form.signup__fields"));
    }

    public boolean isLoginFormPresent() {
        return isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    //additional methods
    public String getEmailTextFromHeader() {
        return getText(By.cssSelector("[href='/account']"));
    }



}
