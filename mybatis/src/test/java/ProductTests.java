import base.ProductBaseTest;
import enums.CategoryType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Category;
import product.Product;
import retrofit2.Response;
import ru.odintsov.db.utils.DbUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductTests extends ProductBaseTest {
    @SneakyThrows
    @Test
    @DisplayName("Проверка сооствествия созданного продукта и проверка добавление в БД")
    void postProductTest() {
        Integer countProductsBefore = DbUtils.countProducts(productsMapper);
        Response<Product> response = productService.createProduct(product).execute();
        Integer countProductsAfter = DbUtils.countProducts(productsMapper);
        assertThat(countProductsAfter, equalTo(countProductsBefore + 1));
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getCategoryTitle(), equalTo(product.getCategoryTitle()));
        productId = response.body().getId();
    }

    @SneakyThrows
    @Test
    @DisplayName("проверка соотвествия категории товара id")
    void getCategoryByIdTest() {
        Integer id = CategoryType.FOOD.getId();
        Response<Category> response = categoryService
                .getCategory(id)
                .execute();

        assertThat(response.body().getTitle(), equalTo(CategoryType.FOOD.getTitle()));
        assertThat(response.body().getId(), equalTo(id));
    }


}
