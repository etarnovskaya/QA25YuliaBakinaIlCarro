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

    @Test(enabled = false)
    public void testFooter() {
        System.out.println("Footer test is started");

        //Search link
        checkFooterPresent();
        click(By.xpath("//section[@class='container footer']//ul//li[1]"));
        String actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Search", actualResult, "Find your car now!");

         //Let the car work link
        checkFooterPresent();
        click(By.xpath("//section[@class='container footer']//ul//li[2]"));
        actualResult = wd.findElement(By.xpath("//h3")).getText();
        textEqualsAssert("Let the car work", actualResult, "Let the car work");

        //ilCarro logo
        checkFooterPresent();
        click(By.xpath("//section[@class='container footer']//img[@alt='logo']"));
        actualResult = wd.findElement(By.xpath("//h2")).getText();
        textEqualsAssert("Main page", actualResult, "Find your car now!");

        System.out.println("Footer test is completed");

    }

}
