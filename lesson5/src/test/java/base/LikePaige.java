package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readproperty.ReadConfig;


public class LikePaige extends BasePaige {
    @FindBy(xpath = "//a[@style='font-weight:600;cursor:pointer']")
    private WebElement likeDisplayedOne;
    @FindBy(xpath = "//a[@style='font-weight:600; cursor:pointer']")
    private WebElement likeDisplayedTwo;

    public LikePaige() {
        super();
    }

    public LikePaige goTo() {
        driver.navigate().to(ReadConfig.URL_LIKE);
        driver.manage().addCookie(new Cookie("_identity_", ReadConfig.COOKIE));
        driver.navigate().refresh();
        return this;
    }

    public boolean getDisplayed() {

        try {
            return waitVisibilityOr(likeDisplayedOne, likeDisplayedTwo);

        } catch (NotFoundException e) {
            return false;
        }


    }
}
