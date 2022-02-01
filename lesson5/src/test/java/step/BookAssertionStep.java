package step;

import base.BookPaige;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookAssertionStep {

    public BookPaige assertCountLikeAndUserName() {
        BookPaige bookPaige = new BookPaige();
        assertAll(() -> assertEquals(Integer.parseInt(bookPaige.getCountLike()) + 1,
                        Integer.parseInt(bookPaige.getCountLike())),
                () -> assertEquals("Diary Spirit", bookPaige.getUserName()));
        return new BookPaige();
    }
}
