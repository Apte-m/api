import enums.CategoryType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import test.BaseTest;
import utils.PrettyLogin;

public class Category extends BaseTest {
    Integer id;

    @DisplayName("Получение категории продукта по id и проверка")
    @Test
    @SneakyThrows
    void getCategoryId() {
        id = CategoryType.ELECTRONIC.getId();

        Response<product.Category> categoryResponse = categoryService.getCategory(id)
                .execute();

        PrettyLogin.DEFAULT.log(categoryResponse.body().toString());
        softAssertions.assertThat(categoryResponse.body().getTitle()).isEqualTo(CategoryType.ELECTRONIC.getTitle());
        softAssertions.assertThat(categoryResponse.body().getId()).isEqualTo(id);


    }
}
