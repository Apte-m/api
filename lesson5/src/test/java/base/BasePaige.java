package base;

import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static settings.Utils.getDriver;

public abstract class BasePaige {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor executor;

    public BasePaige() {
        this.webDriver = getDriver();
        PageFactory.initElements(webDriver, this);
        executor = (JavascriptExecutor) webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);

    }

    public BasePaige(String url, String cookie) {
        this.webDriver = getDriver();
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.navigate().to(url);
        webDriver.manage().addCookie(new Cookie("_identity_", cookie));
        webDriver.navigate().refresh();
    }

    @Description("Ожидание елемента")
    public WebElement waitVisibilityOf(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    @Description("Переключение на другой frame")
    public void switchToIframe(String cssSelector) {
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector(cssSelector)));
    }

    public void clickJavaScript(WebElement locator) {
        executor.executeScript("arguments[0].click();", locator);
    }

    @Description("Переключение на другой tab")
    public void switchToAnotherTab() {
        webDriver.switchTo().window(
                webDriver.getWindowHandles().stream()
                        .filter(h -> !h.equals(webDriver.getWindowHandle()))
                        .findFirst().get()
        );
    }


}
