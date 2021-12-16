package base;

import com.github.javafaker.Faker;
import enums.CategoryType;
import org.junit.jupiter.api.BeforeEach;
import product.Product;

public class ProductBaseTest extends BaseTest {

    protected int productId;
    protected Faker faker = new Faker();
    protected Product product;


    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().dish())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());
    }
}
