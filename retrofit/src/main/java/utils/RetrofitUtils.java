package utils;

import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.Duration;


@UtilityClass
public class RetrofitUtils {
    static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

    public static Retrofit getRetrofitClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(Duration.ofMinutes(1L))
                .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl("http://80.78.248.82:8189/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

}
