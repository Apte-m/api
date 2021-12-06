package nagative.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class NegativeAccountTest extends BaseTest {

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


    @DisplayName("Проверка авторизации пользователя")
    @Test
    void getAccountInfo() {
        given()
                .headers("Authorization", clienID)
                .when()
                .get("https://api.imgur.com/3/account/")
                .then()
                .statusCode(400);
    }
}
