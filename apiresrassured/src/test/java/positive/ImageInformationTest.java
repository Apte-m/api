package positive;

import base.BaseTest;
import image.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class ImageInformationTest extends BaseTest {
    String imageHash;

    @BeforeEach
    void titleUp() {

        imageHash = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .post(IMAGE)
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class)
                .getData()
                .getId();



    }

    @DisplayName("изменение заголовка")
    @Test
    void uploadInfo() {
        given(header,checkResponse)
                .post("image/{imageHash}", imageHash);

    }

}
