import base.DeleteBaseTest;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import ru.odintsov.db.utils.DbUtils;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DeleteTest extends DeleteBaseTest {


    @Test
    void deleteCheck() {
        try {
            Integer countProducts = DbUtils.countProducts(productsMapper);
            Response<Product> response = productService.deleteProduct(productId).execute();
            Integer countProductsAfter = DbUtils.countProducts(productsMapper);
            assertThat(response.code(), is(200));
            assertThat(countProducts, equalTo(countProductsAfter - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
