package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public void waitElement(String element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void switchToIframe (String cssSelector){
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector(cssSelector)));
    }

    public void clickJavaScript (WebElement locator){
        executor.executeScript("arguments[0].click();",locator);
    }


}
