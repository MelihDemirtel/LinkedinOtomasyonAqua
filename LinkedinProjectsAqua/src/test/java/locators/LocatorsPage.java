package locators;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LocatorsPage {
    public SelenideElement userNameLabel = $(By.id("userName"));

    public SelenideElement errorMessage = $(By.className("mb-1"));

    public  SelenideElement passwordLabel = $(By.xpath("//input[@id='password']"));

    public SelenideElement userNameLabelCss = $(By.cssSelector("#userName"));

    public  SelenideElement newUserButton = $(By.xpath("//button[@id='newUser']"));

    public SelenideElement loginButton = $x("//button[@id='login']"); //xpath için farklı bir gösterim şekli.
}
