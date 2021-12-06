package nagative.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import base.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class NegativePictureTest extends BaseTest {
    @DisplayName("Проверка загрузки картики без токена")
    @Test
    void getContentInfoBase64() {
        given()
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .expect()
                .body("success", is(false))
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .statusCode(401);
    }

    @DisplayName("Проверка добавления описания картинки с не верным imageHash")
    @Test
    void getTitleInfo() {
        given()
                .headers("Authorization", token)
                .multiPart("description", "some text")
                .when()
                .post("https://api.imgur.com/3/image/imageDeleteHash")
                .then()
                .statusCode(404);
    }

}
