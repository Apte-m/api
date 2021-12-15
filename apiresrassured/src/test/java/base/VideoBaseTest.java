package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

public abstract class VideoBaseTest extends BaseTest {
    protected static RequestSpecification headerVideo;

    @BeforeEach
    void beforeVideo() {
        headerVideo = new RequestSpecBuilder()
                .addHeader("Authorization", clienID)
                .addMultiPart("image", new File("src/test/resources/images.jpeg"))
                .build();

    }
}
