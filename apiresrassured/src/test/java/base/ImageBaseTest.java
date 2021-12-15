package base;

import image.Response;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.Base64;

import static enpoints.Endpoints.IMAGE;
import static io.restassured.RestAssured.given;

public abstract class ImageBaseTest extends BaseTest {
    protected byte[] image;
    protected String encodedFile;
    protected RequestSpecification headerImageBase64;
    protected MultiPartSpecification headerImageEncoding;
    protected String imageHash;

    @BeforeEach
    void imageUp() {

        headerImage = new RequestSpecBuilder()
                .addHeader("Authorization", clienID)
                .addMultiPart("image", new File("src/test/resources/images.jpeg"))
                .build();

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
}
