package positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ImageTest extends BaseTest {


    @DisplayName("Проверка загрузки картики Base64")
    @Test
    void getContentInfoBase64() {
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

    @DisplayName("Проверка добавления описания картинки")
    @Test
    void getTitleInfo(){
        given()
                .headers("Authorization", token)
                .multiPart("title","Heart","description","some text")
                .expect()
                .body("success",is(true))
                .when()
                .post("https://api.imgur.com/3/image/{imageDeleteHash}",uploadedContent)
                .then()
                .statusCode(200);
    }


    @DisplayName("Проверка загрузки картики из директории ресурс")
    @Test
    @Tag("Skip")
    void getContentImageHash() {
        imageHash = given()
                .headers("Authorization", token)
                .multiPart("image", new File("src/test/resources/images.jpeg"))
                .expect()
                .body("success", is(true))
                .statusCode(200)
                .when()
                .post("https://api.imgur.com/3/image")
                .then()
                .extract()
                .jsonPath()
                .getString("data.id");



    }


    @Test
    @Tag("Skip")
    void favorite() {
        given()
                .headers("Authorization", token)
                .expect()
                .body("success", is(true))
                .when()
                .post("https://api.imgur.com/3/image/{imageHash}/favorite", imageHash)
                .then()
                .statusCode(200);


    }


}




