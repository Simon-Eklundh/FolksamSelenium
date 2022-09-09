package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchingPage {


    WebDriver driver;

    public GoogleSearchingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFolksamLink(){
        WebElement folksamLink = driver.findElement(By.partialLinkText("Folksam Försäkringsbolag – Försäkringar och sparande ..."));
        folksamLink.click();
    }

}
