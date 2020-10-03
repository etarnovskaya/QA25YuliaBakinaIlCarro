package com.telran.qa25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent1(By.xpath("//title[contains(text(),'ilCarr')]"))){
            wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        }

    }

    @Test
    public void testFooter() {
        System.out.println("Footer test is started");

        //Search link
        checkFooterPresent();
        wd.findElement(By.xpath("//section[@class='container footer']//ul//li[1]")).click();
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Search", actualResult, "Find your car now!");

         //Let the car work link
        checkFooterPresent();
        wd.findElement(By.xpath("//section[@class='container footer']//ul//li[2]")).click();
        actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");

        //ilCarro logo
        checkFooterPresent();
        wd.findElement(By.xpath("//section[@class='container footer']//img[@alt='logo']")).click();
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Main page", actualResult, "Find your car now!");

        System.out.println("Footer test is completed");

    }

}
