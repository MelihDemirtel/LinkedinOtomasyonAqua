package elementsExamples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPage {
    //public SelenideElement elementsButton = $(By.xpath("//h5[text()='Elements']"));
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");

    public SelenideElement actualValidationText = $(By.cssSelector(".col-12.mt-4.col-md-6"));

    public SelenideElement textBoxButton = $x("//span[text()='Text Box']");

    public SelenideElement textBoxButtonCss = $(By.cssSelector(".text"));

    public SelenideElement fullNameLabelText = $(By.id("userName-label"));

    public SelenideElement fullNameLabel = $(By.id("userName"));

    public SelenideElement emailLabel = $(By.id("userEmail"));

    public SelenideElement currentAddressLabel = $(By.id("currentAddress"));

    public SelenideElement permanentAddressLabel = $(By.id("permanentAddress"));

    public SelenideElement submitButton = $(By.id("submit"));

    public SelenideElement resultArea = $(By.cssSelector(".border.col-md-12.col-sm-12"));

    public SelenideElement actualName = $x("//p[@id='name']");

    public SelenideElement actualEmail = $(By.id("email"));
    public SelenideElement actualCurrentAddress = $x("//p[@id='currentAddress']");
    public SelenideElement actualPermanentAddress = $x("//p[@id='permanentAddress']");

}
