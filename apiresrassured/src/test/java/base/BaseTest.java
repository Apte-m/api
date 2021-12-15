package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.Matchers.is;

public abstract class BaseTest {

    protected static Properties properties = new Properties();
    protected static String token;
    protected static String username;
    protected static String clienID;
    protected static RequestSpecification header;
    protected static ResponseSpecification checkResponse;
    protected static RequestSpecification headerImage;


    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new AllureRestAssured());
        getProperties();
        token = properties.getProperty("token");
        username = properties.getProperty("username");
        clienID = properties.getProperty("Authorization");
        RestAssured.baseURI = "https://api.imgur.com/3/";

        header = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .addFormParam("description","some")
                .build();


        checkResponse =  new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectBody("success", is(true))
                .expectStatusCode(200)
                .build();





    }

    private static void getProperties() {
        try (InputStream output = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




