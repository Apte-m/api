package positive;

import base.BaseTest;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public class ImageTest extends BaseTest {
    private static byte[] image;
    private static String encodedFile;
    private static RequestSpecification headerImageBase64;
    private static MultiPartSpecification headerImageEncoding;

    @BeforeEach
    void imageUp() {
        image = getContent();
        encodedFile = Base64.getEncoder().encodeToString(image);

        headerImageEncoding = new MultiPartSpecBuilder(encodedFile)
                .controlName("image")
                .build();
        headerImageBase64 = new RequestSpecBuilder()
                .addHeader("Authorization", clienID)
                .addMultiPart(headerImageEncoding)
                .build();

    }

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




