import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class NegativeTest  {

    @DisplayName("Проверка пользователя не корректного ")
    @Test
    void getIncorrectUser() {
        given()
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/account/odintsovv")
                .prettyPeek()
                .then()
                .body("data.error", is("Authentication required"))
                .statusCode(401);
    }


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


}
