package paige;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePaige {
    protected AndroidDriver driver;
    protected WebDriverWait wait;


    public BasePaige(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}
