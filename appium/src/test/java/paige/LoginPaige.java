package paige;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPaige extends BasePaige {


    public LoginPaige(AndroidDriver driver) {
        super(driver);

    }


    public LoginPaige clickLogin() {
        WebElement loginMenuButton = driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        return this;
    }

    public LoginPaige clickButtonLogin() {
        WebElement loginButton = driver.findElementByXPath("//android.view.View[@content-desc=\"button-LOGIN\"]/android.view.View/android.widget.TextView");
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return this;
    }

    public boolean compareText(String checkWord) {
        WebElement errorText = driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.View/android.view.View/android.view.View[4]/android.widget.TextView[1]");
        return errorText.getText().equals(checkWord);

    }
}
