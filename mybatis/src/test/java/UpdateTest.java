import base.UpdateBaseTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class UpdateTest extends UpdateBaseTest {

    @DisplayName("Проверка обновления БД")
    @SneakyThrows
    @Test
    void updateTest() {
        Response<Product> response = productService.updateProduct(product).execute();
        assertThat("Updated", response.isSuccessful());
    }


}
