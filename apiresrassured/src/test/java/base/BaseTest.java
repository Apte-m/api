package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import utils.Utils;

import static org.hamcrest.Matchers.is;

public abstract class BaseTest extends Utils {


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



}




