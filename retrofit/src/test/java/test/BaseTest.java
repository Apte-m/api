package test;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;
import servises.CategoryService;
import servises.ProductService;
import utils.RetrofitUtils;

public class BaseTest {
    protected static Retrofit client;
    protected static ProductService productService;
    protected static CategoryService categoryService;
    protected static SoftAssertions softAssertions;

    @BeforeAll
    static void beforeAll() {

        client = RetrofitUtils.getRetrofitClient();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
        softAssertions = new SoftAssertions();


    }

}
