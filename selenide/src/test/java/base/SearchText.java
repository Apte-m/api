package base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchText {
    private final SelenideElement href = $x("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]");


    public String checkHref(){
        return href.getText();
    }

}
