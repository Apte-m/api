package positive;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.ACCOUNT;
import static io.restassured.RestAssured.given;

public class AccountTest extends BaseTest {

    @DisplayName("Проверка авторизации пользователя")
    @Test
    void getAccountInfoLog() {
        given(header, checkResponse)
                .get(ACCOUNT, username);


    }


}
