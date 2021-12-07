package positive;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DeleteTest extends BaseTest {
    String uploadedContent;

    @BeforeEach
    void deleteUp() {
        uploadedContent = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
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

    @DisplayName("Проверка удаления картинки")
    @Test
    void delete() {
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", uploadedContent)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}

