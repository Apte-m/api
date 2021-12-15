package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FavoriteTest extends ImageBaseTest {



    @DisplayName("проверка добавления картинки в избранное")
    @Test
    void addFavorite() {
        given(header, checkResponse)
                .post("/image/{deleteHash}/favorite", imageHash);
    }
}
