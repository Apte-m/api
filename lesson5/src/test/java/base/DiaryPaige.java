package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readproperty.ReadConfig;

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
        driver.navigate().to(ReadConfig.URL);
        return this;
    }
   @Step ("Вход пользователя логин {0}, пароль {1}")
    public LoginInPaige inputLoginAndPassword(String login, String password) {
        input.click();
        waitVisibilityOf(inputText).sendKeys(login);
        inputPassword.sendKeys(password);
        switchToIframe("iframe[title='reCAPTCHA']");
        clickJavaScript(captcha);
        driver.switchTo().parentFrame();
        comeIn.click();
        return new LoginInPaige();
    }


}
