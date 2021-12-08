package positive;

import base.BaseTest;
import image.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class FavoriteTest extends BaseTest {

    private String imageHash;

    @BeforeEach
    void favorite() {
        imageHash = given(headerImage)
                .post(IMAGE)
                .then()
                .extract()
                .response()
                .as(Response.class)
                .getData()
                .getId();


    }

    @DisplayName("проверка добавления картинки в избранное")
    @Test
    void addFavorite() {
        given(header, checkResponse)
                .post("/image/{deleteHash}/favorite", imageHash);
    }
}
