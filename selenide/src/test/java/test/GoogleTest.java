package test;

import base.BaseSelenideTest;
import base.GooglePaige;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest extends BaseSelenideTest {
    private final static String BASE_URL = "https://www.google.com/";
    private final static String SEARCH_STRING = "документация - Selenide";

    @Test
    public void checkSearchInputText() {
        assertTrue(new GooglePaige(BASE_URL)
                .setTextBoxInput(SEARCH_STRING)
                .checkHref()
                .contains(SEARCH_STRING));
    }


}
