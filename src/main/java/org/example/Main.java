package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Main {
    public Main() {

    }

    public static void main(String[] args) {

        new Main().runWebsiteTest();


    }

    private void runWebsiteTest() {
        //setup
        DriverSetup driverSetup = new DriverSetup();
        WebDriver driver = driverSetup.getDriver();

        //navigate to google.com
        driver.get("https://www.google.com");

        // google home page start
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchforFolksam();
        // google home page end

        //google search done page start
        //going to Folksam
        GoogleSearchingPage googleSearchingPage = new GoogleSearchingPage(driver);
        googleSearchingPage.clickOnFolksamLink();
        // end

        // folksam start page
        FolksamHomePage folksamHomePage = new FolksamHomePage(driver);
        folksamHomePage.removeCookies();
        folksamHomePage.goToHomeInsurance();

        // folksam start page end

        // folksam home insurance page
        FolksamHomeInsurancePage folksamHomeInsurancePage = new FolksamHomeInsurancePage(driver);
        WebElement insuranceElement = folksamHomeInsurancePage.getInsuranceElement();
        //end

        System.out.println(insuranceElement.getText());

        driver.quit();
    }




}