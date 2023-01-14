package elementsExamples;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckBoxPage {
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement checkBoxButton = $x("//span[text()='Check Box']");
    public SelenideElement checkBoxHomeButton = $(By.className("rct-title"));
    public ElementsCollection resultHome = $$x(("//span[@class='text-success']"));
    public SelenideElement toggleButton1 = $x("(//button[@title='Toggle'])[1]");
    public SelenideElement checkBoxDesktop = $x("//span[contains(text(),'Desktop')]");
    public SelenideElement checkBoxDocument = $x("//span[contains(text(),'Document')]");
    public SelenideElement checkBoxDownloads = $x("//span[contains(text(),'Downloads')]");
}
