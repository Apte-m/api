package test;

import base.BookNote;
import base.BookPaige;
import base.DiaryPaige;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readProperty.ReadConfig;
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

    @DisplayName("Проверка добавления лайка пользователю Diary Spirit")
    @Test
    void checkLike() {

        BookPaige bookPaige = new BookPaige();
        bookPaige
                .goToNewsAndClickLikeFirstLabel()
                .simpleReturnClick();


        assertTrue(EqualsBuilder.reflectionEquals(new BookNote(bookPaige.getCountLike(), bookPaige.getUserName()),
                new BookNote("17", "Diary Spirit")));

        bookPaige
                .simpleReturnClick(); // Здесь я возвращаю обратно клик подскажите правильно делать это в методе или
        // лучше вынести ???


    }


}
