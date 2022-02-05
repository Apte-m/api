package facktory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-blink-features=AutomationControlled");
                webDriver = new ChromeDriver(options);
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                FirefoxOptions optionsFire = new FirefoxOptions();
                optionsFire.addArguments("--disable-blink-features=AutomationControlled");
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(optionsFire);
                break;

        }
        return webDriver;
    }
}
