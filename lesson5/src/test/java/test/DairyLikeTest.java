package test;

import base.BookPaige;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.Utils;

public class DairyLikeTest extends Utils {

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
