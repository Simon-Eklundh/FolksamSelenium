import org.example.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class OutputTest {
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
    @Test(groups = {"full"})
    public void testFullFunctionality() {
        driver.get("https://www.google.com");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.acceptCookies();
        googleHomePage.searchforFolksam();

        //going to Folksam
        new GoogleSearchingPage(driver).clickOnFolksamLink();

        //clicking the cookies on folksam
        FolksamHomePage folksamHomePage = new FolksamHomePage(driver);
        folksamHomePage.removeCookies();
        folksamHomePage.goToHomeInsurance();



        // get the text "Sveriges populäraste hemförsäkring"
        String result = new FolksamHomeInsurancePage(driver).getInsuranceElement().getText();
        assert result.equals("Sveriges populäraste hemförsäkring");
    }

}
