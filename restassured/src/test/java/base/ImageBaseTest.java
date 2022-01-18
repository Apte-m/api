package base;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.Utils.getContent;

public class ImageBaseTest extends BaseTest {
    protected static byte[] image;
    protected static String encodedFile;
    protected static String uploadedContent;
    protected String imageHash;
    protected String deleteHash;
    private Response env;

    @BeforeEach
    void imageUp() {
        image = getContent();
        encodedFile = Base64.getEncoder().encodeToString(image);

        env = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .expect()
                .body("success", is(true))
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract().response();


        imageHash = env.jsonPath().getString("data.id");
        deleteHash = env.jsonPath().getString("data.deletehash");

    }

}
