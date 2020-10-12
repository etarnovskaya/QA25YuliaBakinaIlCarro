package com.telran.qa25.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterHelper extends HelperBase {

    public FooterHelper(WebDriver wd) {
        super(wd);
    }

    //check footer methods
    public boolean isFooterPresent() {
        return isElementPresent1(By.className("class='container-full'"));

    }

    public void makeFooterPresent(){
        if(!isFooterPresent()){
            clickLogoIconOnHeader();
        }
    }

    //click footer links methods
    public void clickSearchLinkOnFooter() {
        click(By.xpath("//section[@class='container header']//ul//li[1]"));
    }

    public void clickAddCarLinkOnFooter() {
        click(By.xpath("//section[@class='container header']//ul//li[2]"));
    }

    public void clickLogoIconOnFooter() {
        click(By.xpath("//section[@class='container footer']//img[@alt='logo']"));
    }


}
