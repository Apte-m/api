import com.github.javafaker.Faker;
import enums.CategoryType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import retrofit2.Response;
import test.BaseTest;

import java.util.ArrayList;

public class ProductTest extends BaseTest {

    Faker faker = new Faker();
    Product product;
    Integer id;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        product = new Product().withTitle(faker.artist().name())
                .withPrice((int) (Math.random() + 1) * 100)
                .withCategoryTitle(CategoryType.ELECTRONIC.getTitle());

        Response<Product> response = productService.createProduct(product).execute();

        id = response.body().getId();


    }


    @DisplayName("получить все продукты ")
    @SneakyThrows
    @Test
    void getProduct() {
        Response<ArrayList<Product>> response = productService.getProducts()
                .execute();
        softAssertions.assertThat(response.headers()).isEqualTo(200);
    }

    @DisplayName("получить продукт по id")
    @Test
    @SneakyThrows
    void getProductId() {
        Response<Product> response = productService.getProduct(id).execute();
        softAssertions.assertThat(response.headers()).isEqualTo(200);
    }


    @DisplayName("создание продукта")
    @Test
    @SneakyThrows
    void postProductCreate() {

        Response<Product> response = productService
                .createProduct(product)
                .execute();


        softAssertions.assertThat(response.body().getTitle())
                .isEqualTo(product.getTitle());
        softAssertions.assertThat(response.body().getPrice())
                .isEqualTo(product.getPrice());
        softAssertions.assertThat(response.body().getCategoryTitle())
                .isEqualTo(product.getCategoryTitle());
        softAssertions.assertAll();


    }

    @DisplayName("изменение названия продукта")
    @Test
    @SneakyThrows
    void chanceProduct() {
        Response<Product> response = productService
                .chanceProduct(product.withId(id)
                        .withTitle(faker.animal().name())).execute();
        softAssertions.assertThat(response.headers())
                .isEqualTo(200);
    }

    @DisplayName("проверка удаления продукта")
    @Test
    void deleteProduct() {
        softAssertions.assertThat(productService.deleteProduct(id)).isEqualTo(200);

    }


}
