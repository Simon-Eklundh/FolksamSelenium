package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    private final WebDriver driver;

    public DriverSetup() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
