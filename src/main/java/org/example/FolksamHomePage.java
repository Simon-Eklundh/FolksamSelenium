package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FolksamHomePage {

    WebDriver driver;

    public FolksamHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeCookies(){
        //clicking the cookies on folksam
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    public void goToHomeInsurance(){
        WebElement homeInsuranceLink = driver.findElement(By.className("primary-pathways__list")).findElements(By.tagName("li")).get(1).
                findElement(By.tagName("a"));
        //System.out.println(HomeInsuranceLink);
        homeInsuranceLink.click();
    }


}
