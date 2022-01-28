package test;

import org.junit.Test;
import settings.Utils;

import static data.Data.LOGIN;
import static data.Data.PASSWORD;


public class DiaryTest extends Utils {


    @Test
    public void smoke()  {
        diaryPaige
                .goTo()
                .inputLoginAndPassword(LOGIN, PASSWORD)
                .goToNewsAndClickLikeFirstLabel();
    }
}
