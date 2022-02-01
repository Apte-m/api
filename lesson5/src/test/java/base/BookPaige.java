package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readproperty.ReadConfig;
import step.BookAssertionStep;

public class BookPaige extends BasePaige {
    @FindBy(xpath = "//*[contains(text(),'Новости дневников')]")
    private WebElement news;
    @FindBy(xpath = "//*[@class='name_likes']")
    private WebElement like;
    @FindBy(id = "blog_post_like_220940759")
    private WebElement countLike;
    @FindBy(xpath = "//div[@class='authorName']//a[@class='user']")
    private WebElement userName;
    @FindBy(xpath = "//a[@style='font-weight:600; cursor:pointer']")
    private WebElement likeDisplayed;

    public BookPaige() {
        super();
    }

    public BookPaige goTo (){
        webDriver.navigate().to(ReadConfig.URL);
        webDriver.manage().addCookie(new Cookie("_identity_", ReadConfig.COOKIE));
        webDriver.navigate().refresh();
        return this;
    }
    public BookPaige goToNewsAndClickLikeFirstLabel() {
        waitVisibilityOf(news).click();
        return this;

    }

    public BookAssertionStep simpleReturnClick() {
        like.click();
        return new BookAssertionStep();
    }

    public String getCountLike() {
        return countLike.getText();
    }

    public String getUserName() {
        return userName.getText();
    }

    public boolean getDisplayed() {

       try {
           return waitVisibilityOf(likeDisplayed).isDisplayed();
       }catch (NotFoundException e) {
           return false;
       }



    }

}
