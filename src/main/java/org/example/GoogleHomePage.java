package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class GoogleHomePage {

    WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookies(){
        driver.manage().deleteCookieNamed("CONSENT");
        driver.manage().addCookie(new Cookie("CONSENT", "YES+shp.gws-" +LocalDate.now().toString().replace("-", "") + "-0-RC2.en+FX+374"));
        driver.navigate().refresh();
    }

    // trick google into thinking we've consented to cookies
    //
  public void searchforFolksam(){
      WebElement googleSearchBox = driver.findElement(By.name("q"));

      googleSearchBox.sendKeys("folksam");
      googleSearchBox.submit();
  }
    // searching on google


}
