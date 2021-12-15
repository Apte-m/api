package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FavoriteTest extends ImageBaseTest {


    @DisplayName("проверка добавления картинки в избранное")
    @Test
    void addFavorite() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", imageHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
