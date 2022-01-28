package settings;

import base.DiaryPaige;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    private static WebDriver driver;
    private WebDriverWait webDriverWait;
    protected DiaryPaige diaryPaige;


    public static WebDriver getDriver() {
        return driver;
    }


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver,10);
        diaryPaige = new DiaryPaige();
    }

    @After
    public void rearDown() {

            driver.quit();

    }
}
