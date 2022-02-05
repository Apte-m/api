package test;

import base.BookPaige;
import base.LikePaige;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.UtilsTest;

import static org.junit.jupiter.api.Assertions.*;



@DisplayName("Добавлени лайка")
public class LikeTest extends UtilsTest {


    @DisplayName("Проверка добавления лайка пользователю Diary Spirit")
    @Test
    void checkLike() {
        assertAll(() -> assertTrue(new BookPaige().goTo().goToNewsAndClickLikeFirstLabel().simpleReturnClick().getDisplayed()),
                () -> assertEquals("Diary Spirit", new BookPaige().getUserName()));
    }


    @AfterEach
    void tearDownLike() {
        new LikePaige().goTo();
        if (new LikePaige().getDisplayed()) {
            new BookPaige().simpleReturnClick();
        }

    }
}
