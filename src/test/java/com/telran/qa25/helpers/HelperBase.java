package com.telran.qa25.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd){
       this.wd = wd;
    }

    public void clickLogoIconOnHeader() {
        click(By.xpath("//section[@class='container header']//img[@alt='logo']"));
    }

    public boolean isElementPresent1(By locator) {
        return wd.findElements(locator).size()>0;

    }

    public void delay(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
   }

    public void type(By locator, String text) {
            click(locator);
//            wd.findElement(locator).clear(); //- doesn't work for Login form

            wd.findElement(locator).sendKeys(Keys.CONTROL + "a");
            wd.findElement(locator).sendKeys(Keys.DELETE);

            if(text != null){
                wd.findElement(locator).sendKeys(text);
            }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean checkSubmitButtonIsAvailable(){
       return !(isElementPresent1(By.xpath("//input[@type='submit'][@disabled]")));
    }

    public void clickSubmitForm() {
        new WebDriverWait(wd,15).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
    }

    public String getText(By locator) {
        return wd.findElement(locator).getText();
    }

}
