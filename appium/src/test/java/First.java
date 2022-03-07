import org.testng.annotations.Test;
import paige.LoginPaige;
import paige.SwipePaige;
import settings.SettingStart;

import static data.DataInput.CHECK_EMAIL;
import static data.DataInput.CHECK_GIT_HUB;
import static org.testng.Assert.assertTrue;

public class First extends SettingStart {
    @Test
    public void CheckEmptyEmail() {
        assertTrue(new LoginPaige(driver)
                .clickLogin()
                .clickButtonLogin()
                .compareText(CHECK_EMAIL.getValue()));

    }

    @Test
    public void checkGitHub() {
        assertTrue(new SwipePaige(driver)
                .clickSwipe()
                .checkText(CHECK_GIT_HUB.getValue()));

    }
}


