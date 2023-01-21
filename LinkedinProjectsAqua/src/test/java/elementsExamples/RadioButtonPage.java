package elementsExamples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RadioButtonPage {
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement radioButton = $x("//span[text()='Radio Button']");
    public SelenideElement radioButtonPageMessage = $(By.cssSelector(".mb-3"));
    public SelenideElement radioYesButton = $(By.cssSelector("label[for='yesRadio']"));
    public SelenideElement radioImpressiveButton = $(By.cssSelector("label[for='impressiveRadio']"));
    public SelenideElement radioNoButton = $(By.cssSelector("label[for='noRadio']"));
    public SelenideElement radioYesButtonMessage = $(By.className("text-success"));
    public SelenideElement radioImpressiveButtonMessage = $(By.className("text-success"));


}
