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
        bookPaige.goToNewsAndClickLikeFirstLabel().getCountLike();
        BookNote bookNoteActual = new BookNote(bookPaige.getCountLike(), bookPaige.getUserName());
        BookNote bookNoteExpect = new BookNote("17", "Diary Spirit");

        assertTrue(EqualsBuilder.reflectionEquals(bookNoteActual, bookNoteExpect));

        bookPaige.simpleReturnClick(); // Здесь я возвращаю обратно клик подскажите правильно делать это в методе или
        // лучше вынести ???


    }


}
