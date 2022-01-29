package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readProperty.ReadConfig;

public class DiaryPaige extends BasePaige {
    @FindBy(xpath = "//a[contains(@href,'login')]")
    private WebElement input;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-borderAnimation']")
    private WebElement captcha;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputText;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[.='Войти']")
    private WebElement comeIn;


    public DiaryPaige() {
        super();
    }


    public DiaryPaige goTo() {
        webDriver.navigate().to(ReadConfig.URL);
        return this;
    }

    public LoginInPaige inputLoginAndPassword(String login, String password) {
        input.click();
        waitVisibilityOf(inputText).sendKeys(login);
        inputPassword.sendKeys(password);
        switchToIframe("iframe[title='reCAPTCHA']");
        clickJavaScript(captcha);
        webDriver.switchTo().parentFrame();
        comeIn.click();
        return new LoginInPaige();
    }


}
