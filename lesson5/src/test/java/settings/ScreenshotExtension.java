package settings;

import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static settings.UtilsTest.getDriver;

public class ScreenshotExtension implements TestWatcher {
    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        WebDriver driver = getDriver();
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
    }
}
