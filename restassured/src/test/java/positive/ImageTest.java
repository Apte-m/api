package positive;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ImageTest extends BaseTest {
    protected static byte[] image;
    protected static String encodedFile;

    @BeforeEach
    void imageUp() {
        image = getContent();
        encodedFile = Base64.getEncoder().encodeToString(image);
    }

    @DisplayName("Проверка загрузки картики Base64")
    @Test
    void getContentInfoBase64Test() {
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

    @DisplayName("Проверка загрузки картики из директории ресурс")
    @Test
    void getContentInfo() {
        uploadedContent = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .expect()
                .body("success", is(true))
                .log()
                .all()
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .extract()
                .jsonPath()
                .getString("data.deletehash");

    }


    private static byte[] getContent() {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File("src/test/resources/images.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }


}




