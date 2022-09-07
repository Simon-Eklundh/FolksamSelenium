package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        //setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //navigate to google.com
        driver.get("https://www.google.com");

        // trick google into thinking we've consented to cookies
        driver.manage().deleteCookieNamed("CONSENT");
        driver.manage().addCookie(new Cookie("CONSENT", "YES+shp.gws-" + LocalDate.now().toString().replace("-", "") + "-0-RC2.en+FX+374"));
        driver.navigate().refresh();

        // searching on google
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("folksam");
        googleSearchBox.submit();

        //going to Folksam
        WebElement folksamLink = driver.findElement(By.partialLinkText("Folksam Försäkringsbolag – Försäkringar och sparande ..."));
        folksamLink.click();

        //clicking the cookies on folksam
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //the original way of making sure I got the correct link. I did this as I couldn't get primary pathways to
        // work at first
       /* WebElement TEST =
                driver.findElement(By.id("main")).
                        findElement(By.className("u-bgcolor-beige-3")).
                        findElement(By.className("content-wrapper")).
                        findElement(By.className("primary-pathways")).
                        findElement(By.className("grid-wrapper")).
                        findElement(By.className("grid")).
                        findElement(By.className("primary-pathways__list")).
                        findElements(By.tagName("li")).get(1).
                        findElement(By.tagName("a"));
        System.out.println(TEST.toString());*/


        // clicking the folksam Home insurance link
        WebElement homeInsuranceLink = driver.findElement(By.className("primary-pathways__list")).findElements(By.tagName("li")).get(1).
                findElement(By.tagName("a"));
        //System.out.println(HomeInsuranceLink);
        homeInsuranceLink.click();


        WebElement textToText = driver.findElement(By.className("article__fragment")).findElement(By.tagName("h1"));
        System.out.println(textToText.getText());


        while (true) {

        }

        // driver.quit();
    }
}