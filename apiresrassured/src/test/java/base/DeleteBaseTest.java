package base;

import image.Response;
import org.junit.jupiter.api.BeforeEach;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class DeleteBaseTest extends BaseTest {
    protected String deleteHash;

    @BeforeEach
    void deleteUp() {
        deleteHash = given(headerImage)
                .post(IMAGE)
                .then()
                .extract()
                .response()
                .as(Response.class)
                .getData()
                .getDeletehash();

    }
}
