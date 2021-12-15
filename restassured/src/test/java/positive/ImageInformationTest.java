package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ImageInformationTest extends ImageBaseTest {


    @DisplayName("изменение заголовка")
    @Test
    void uploadInfo() {
        given()
                .headers("Authorization", token)
                .param("title", "description")
                .when()
                .post("https://api.imgur.com/3/image/{imageHash}", imageHash)
                .then()
                .statusCode(200);

    }

}
