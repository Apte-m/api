package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryPaige extends BasePaige {
    @FindBy(xpath = "//a[contains(@href,'login')]")
    WebElement input;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-borderAnimation']")
    WebElement captcha;
    @FindBy(xpath = "//input[@type='text']")
    WebElement inputText;
    @FindBy(xpath = "//input[@type='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//*[contains(text(),'Новости дневников')]")
    WebElement news;
    @FindBy(xpath = "//*[@class='name_likes']")
    WebElement like;

    public DiaryPaige() {
        super();
    }


    public DiaryPaige goTo() {
        webDriver.navigate().to("https://diary.ru/");
        return this;
    }

    public DiaryPaige inputLoginAndPassword(String login, String password) {
        input.click();

        inputText.sendKeys(login);
        inputPassword.sendKeys(password);
        switchToIframe("iframe[title='reCAPTCHA']");
        clickJavaScript(captcha);
        return this;
    }


    public DiaryPaige goToNewsAndClickLikeFirstLabel() {
        waitElement("//*[contains(text(),'Новости дневников')]");
        news.click();
        like.click();
        return this;

    }
}
