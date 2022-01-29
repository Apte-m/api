package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readProperty.ReadConfig;

public class LoginInPaige extends BasePaige {

    @FindBy(xpath = "//li[.='PandaAutoTest']")
    private WebElement locatedLogin;

    public LoginInPaige() {
        super();
    }


    public boolean isLoginChecked() {
        try {
            return waitVisibilityOf(locatedLogin).getText().equals(ReadConfig.LOGIN);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;

        }
    }
}
