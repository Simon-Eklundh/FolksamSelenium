import org.example.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class FolksamHomePageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // code that will be invoked when this test is instantiated
        driver = new DriverSetup().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testRemoveCookies() {
        driver.get("https://www.folksam.se/");
        new FolksamHomePage(driver).removeCookies();

        assert !driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed();

    }


    @Test
    public void testGoToHomeInsurance() {
        driver.get("https://www.folksam.se");
        FolksamHomePage folksamHomePage = new FolksamHomePage(driver);
        folksamHomePage.removeCookies();
        folksamHomePage.goToHomeInsurance();
        assert driver.getTitle().equals("Hemförsäkring - Bäst enligt Konsumenternas - Folksam");

    }
}
