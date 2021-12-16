package base;

import com.github.javafaker.Faker;
import enums.CategoryType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import product.Product;
import retrofit2.Response;

public class UpdateBaseTest extends BaseTest {

    protected int productId;
    protected Faker faker = new Faker();
    protected Product product;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().dish())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());

        Response <Product> response = productService.createProduct(product).execute();
        productId = response.body().getId();
        product.setId(productId);
        product.setPrice(34);
    }

}
