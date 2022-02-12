package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readproperty.ReadConfig;


public class BookPaige extends BasePaige {
    @FindBy(xpath = "//*[contains(text(),'Новости дневников')]")
    private WebElement news;
    @FindBy(xpath = "//*[@class='name_likes']")
    private WebElement like;
    @FindBy(id = "blog_post_like_220940759")
    private WebElement countLike;
    @FindBy(xpath = "//div[@class='authorName']//a[@class='user']")
    private WebElement userName;


    public BookPaige() {
        super();
    }

    public BookPaige goTo() {
        driver.navigate().to(ReadConfig.URL);
        driver.manage().addCookie(new Cookie("_identity_", ReadConfig.COOKIE));
        driver.navigate().refresh();
        return this;
    }

    public BookPaige goToNewsAndClickLikeFirstLabel() {
        waitVisibilityOf(news).click();
        return this;

    }

    public LikePaige simpleReturnClick() {
        like.click();
        return new LikePaige();
    }


    public String getUserName() {
        return userName.getText();
    }


}
