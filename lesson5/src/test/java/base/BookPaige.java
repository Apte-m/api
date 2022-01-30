package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readProperty.ReadConfig;

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
        super(ReadConfig.URL, ReadConfig.COOKIE);
    }


    public BookPaige goToNewsAndClickLikeFirstLabel() {
        waitVisibilityOf(news).click();
        return this;

    }
    public void simpleReturnClick (){
        like.click();
    }

    public String getCountLike() {
        return countLike.getText();
    }

    public String getUserName() {
        return userName.getText();
    }

}
