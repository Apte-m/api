package positive;

import base.BaseTest;
import image.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.DELETE;
import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class DeleteTest extends BaseTest {
    private String uploadedContent;

    @BeforeEach
    void deleteUp() {
        uploadedContent = given(headerImage)
                .post(IMAGE)
                .then()
                .extract()
                .response()
                .as(Response.class)
                .getData()
                .getDeletehash();

    }

    @DisplayName("Проверка удаления картинки")
    @Test
    void delete() {
        given(header, checkResponse)
                .delete(DELETE, uploadedContent);
    }
}

