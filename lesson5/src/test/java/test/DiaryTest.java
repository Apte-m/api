package test;

import base.BookPaige;
import base.DiaryPaige;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readproperty.ReadConfig;
import settings.Utils;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("Проверка добавления лайка пользователю Diary Spirit")
    @Test
    void checkLike() {
        new BookPaige()
                .goTo()
                .goToNewsAndClickLikeFirstLabel()
                .simpleReturnClick()
                .assertCountLikeAndUserName();
    }


    @AfterEach
    void tearDown() {
        BookPaige bookPaige = new BookPaige();
        bookPaige
                .goTo()
                .goToNewsAndClickLikeFirstLabel();
        if (bookPaige.getDisplayed()) {
            bookPaige.simpleReturnClick();
        }
    }


}
