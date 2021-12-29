package positive;

import base.ImageBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class ImageTest extends ImageBaseTest {


    @DisplayName("Проверка загрузки картики Base64")
    @Test
    void getContentInfoBase64Test() {
        given(headerImageBase64, checkResponse)
                .post(IMAGE);

    }

    @DisplayName("Проверка загрузки картики из директории ресурс")
    @Test
    void getContentInfo() {
        given(headerImage, checkResponse)
                .post(IMAGE);


    }


}




