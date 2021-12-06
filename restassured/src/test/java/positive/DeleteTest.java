package positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DeleteTest extends ImageTest {
    String uploadedContent;

    public DeleteTest() {
        super();
    }

    @BeforeEach
    void deleteUp() {
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

