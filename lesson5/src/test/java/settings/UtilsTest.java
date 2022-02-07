package settings;

import facktory.Browsers;
import facktory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@ExtendWith(ScreenshotExtension.class)
public class UtilsTest {
    private static EventFiringWebDriver eventFiringWebDriver;

    public static WebDriver getDriver() {
        return eventFiringWebDriver;
    }


    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        eventFiringWebDriver = new EventFiringWebDriver(DriverFactory.getWebDriver(Browsers.CHROME));
        eventFiringWebDriver.register(new CustomLogger());
        eventFiringWebDriver.manage().window().maximize();
    }


    @AfterAll
    public static void tearDown() {
        eventFiringWebDriver.quit();
    }
}
