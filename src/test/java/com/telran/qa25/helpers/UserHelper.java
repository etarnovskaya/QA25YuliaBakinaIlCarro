package com.telran.qa25.helpers;

import com.telran.qa25.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd){
        super(wd);
    }

    public boolean isUserLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void logOut(){
       click(By.xpath("//a[contains(., 'logOut')]"));
    }

   //filling forms methods
    public void fillLoginUserForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public boolean isCheckPolicyMarked(){
        return isElementPresent1(By.cssSelector("[id='check_policy'][checked]"));
    }

    public void clickCheckPolicy() {
       click(By.cssSelector("#check_policy"));
   }


}
