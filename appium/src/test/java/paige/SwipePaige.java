package paige;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SwipePaige extends BasePaige {
    public SwipePaige(AndroidDriver driver) {
        super(driver);
    }

    public SwipePaige clickSwipe () {
        WebElement swipeElement =  driver.findElementByXPath("//android.view.View[@content-desc=\"Swipe\"]/android.widget.TextView");
        swipeElement.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return this;
    }

    public boolean checkText (String text){
        WebElement elementText =  driver.findElementByXPath("(//android.view.View[@content-desc=\"card\"])[1]/android.widget.TextView[2]");
        return elementText.getText().equals(text);
    }
}
