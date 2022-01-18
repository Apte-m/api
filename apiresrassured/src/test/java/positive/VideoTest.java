package positive;

import base.VideoBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.UPLOAD;
import static io.restassured.RestAssured.given;

public class VideoTest extends VideoBaseTest {

    @DisplayName("Проверка загрузки видео из директории ресурс")
    @Test
    void getContentInfo() {
        given(headerVideo, checkResponse)
                .post(UPLOAD);


    }
}
