package tests;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod (alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser){

        driver = DriverManager.setDriver(browser);
        softAssert = new SoftAssert();
        driver.get("https://demo.opencart.com/");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        driver.quit();

    }


}
