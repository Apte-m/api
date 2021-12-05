package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    protected Properties properties = new Properties();
    protected static String token;
    public static String username;
    protected String clienID;
    protected byte[] image;
    protected String encodedFile;
    protected String uploadedContent;
    protected  String imageHash;


    @BeforeEach
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new AllureRestAssured());
        getProperties();
        token = properties.getProperty("token");
        username = properties.getProperty("username");
        clienID = properties.getProperty("Authorization");
        image = getContent();
        encodedFile = Base64.getEncoder().encodeToString(image);


    }

    private void getProperties() {
        try (InputStream output = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getContent() {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File("src/test/resources/images.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }

    @AfterEach
    void tearDown(TestInfo testInfo) {

        if (testInfo.getTags().contains("Skip")) {
            return;
        }
        given()
                .headers("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{deleteHash}", uploadedContent)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

}




