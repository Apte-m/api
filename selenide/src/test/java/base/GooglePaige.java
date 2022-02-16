package base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GooglePaige {
    private final SelenideElement textBoxInput = $("input[name=q]");

    public GooglePaige(String url) {
        Selenide.open(url);
    }

    public SearchText setTextBoxInput (String textNameSearch){
        textBoxInput.click();
        textBoxInput.setValue(textNameSearch).sendKeys(Keys.RETURN);
        return page(SearchText.class);

    }
}
