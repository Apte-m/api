package positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountTest extends BaseTest {


    @DisplayName("Проверка авторизации пользователя")
    @Test
    @Tag("Skip")
    void getAccountInfo() {
        given()
                .headers("Authorization", clienID)
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .then()
                .statusCode(200);
    }


    @DisplayName("Проверка авторизации пользователя с логированием")
    @Test
    @Tag("Skip")
    void getAccountInfoLog() {
        given()
                .headers("Authorization", clienID)
                .log()
                .method()
                .expect()
                .statusCode(200)
                .body("success", equalTo(true))
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();


    }




}
