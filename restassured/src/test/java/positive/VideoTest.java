package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.given;

public class VideoTest extends ImageBaseTest {



    @DisplayName("Проверка удаления картинки")
    @AfterEach
    void tearDown() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", deleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
