package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.Utils;

public abstract class BaseTest extends Utils {


    protected static String token;
    public static String username;
    protected static String clienID;


    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new AllureRestAssured());
        getProperties();
        token = properties.getProperty("token");
        username = properties.getProperty("username");
        clienID = properties.getProperty("Authorization");


    }


}




