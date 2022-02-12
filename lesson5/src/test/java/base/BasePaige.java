package base;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static settings.UtilsTest.getDriver;

public abstract class BasePaige {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor executor;

    public BasePaige() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        executor = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, 20);

    }


    @Description("Ожидание елемента")
    public WebElement waitVisibilityOf(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    @Description("Ожидание елемента")
    public Boolean waitVisibilityOr(WebElement elementOne, WebElement elementTwo) {
        return webDriverWait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(elementOne),
                ExpectedConditions.visibilityOf(elementTwo)
        ));

    }

    @Description("Переключение на другой frame")
    public void switchToIframe(String cssSelector) {
        driver.switchTo().frame(driver.findElement(By.cssSelector(cssSelector)));
    }

    public void clickJavaScript(WebElement locator) {
        executor.executeScript("arguments[0].click();", locator);
    }

    @Description("Переключение на другой tab")
    public void switchToAnotherTab() {
        driver.switchTo().window(
                driver.getWindowHandles().stream()
                        .filter(h -> !h.equals(driver.getWindowHandle()))
                        .findFirst().get()
        );
    }


}
