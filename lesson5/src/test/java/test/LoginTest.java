package test;

import base.DiaryPaige;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readproperty.ReadConfig;
import settings.UtilsTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
@DisplayName("Проверка входа")
public class LoginTest extends UtilsTest {


    @DisplayName("Проверка сооствестивие логина")
    @Test
    void smoke() {
        assertTrue(
                new DiaryPaige()
                        .goTo()
                        .inputLoginAndPassword(ReadConfig.LOGIN, ReadConfig.PASSWORD)
                        .isLoginChecked());

    }


}
