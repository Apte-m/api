package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ImageTest extends ImageBaseTest {

    @DisplayName("Проверка загрузки картики Base64")
    @Test
    void getContentInfoBase64Test() {
        uploadedContent = given()
                .headers("Authorization", token)
                .multiPart("image", encodedFile)
                .expect()
                .body("success", is(true))
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .extract()
                .jsonPath()
                .getString("data.deletehash");
    }

    @DisplayName("Проверка загрузки картики из директории ресурс")
    @Test
    void getContentInfo() {
        uploadedContent = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .expect()
                .body("success", is(true))
                .log()
                .all()
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .extract()
                .jsonPath()
                .getString("data.deletehash");

    }

    @DisplayName("Проверка удаления картинки")
    @AfterEach
    void tearDown() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", uploadedContent)
                .prettyPeek()
                .then()
                .statusCode(200);
    }





}




