package test;

import base.DiaryPaige;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readproperty.ReadConfig;
import settings.Utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiaryTest extends Utils {


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
