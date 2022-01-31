package settings;

import facktory.Browsers;
import facktory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Utils {

    private static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }


    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getWebDriver(Browsers.CHROME);
        driver.manage().window().maximize();


    }


    @AfterAll
    public static void rearDown() {
        driver.quit();


    }
}
