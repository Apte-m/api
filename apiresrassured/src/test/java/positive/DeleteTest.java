package positive;

import base.DeleteBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static enpoints.Endpoints.DELETE;
import static io.restassured.RestAssured.given;

public class DeleteTest extends DeleteBaseTest {

    @DisplayName("Проверка удаления картинки")
    @Test
    void delete() {
        given(header, checkResponse)
                .delete(DELETE, uploadedContent);
    }
}

