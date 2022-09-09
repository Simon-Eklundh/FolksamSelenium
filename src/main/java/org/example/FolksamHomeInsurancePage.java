package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FolksamHomeInsurancePage {

    WebDriver driver;

    public FolksamHomeInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getInsuranceElement(){
        return driver.findElement(By.className("article__fragment")).findElement(By.tagName("h1"));
    }


}
