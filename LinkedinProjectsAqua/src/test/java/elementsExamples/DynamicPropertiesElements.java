package elementsExamples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicPropertiesElements {
    //ELEMENTS
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement dynamicPropertiesButton = $x("//span[text()='Dynamic Properties']");
    public SelenideElement firstRandomIdText;
    public SelenideElement SecondRandomIdText;
    public SelenideElement enableButton = $(By.id("enableAfter"));
    public SelenideElement colorButton = $(By.id("colorChange"));
    public SelenideElement visibleButton = $(By.id("visibleAfter"));

    //OTHER
    public int milis = 6000;
    public String scrollDown = "window.scrollBy(0,350)";//Sayfayı aşağı kaydırabilmek için
    public String firstRandomIdAttribute;
    public String secondRandomIdAttribute;
    public boolean enableButtonIsEnable;
    public String firstColorButtonAttribute;
    public String secondColorButtonAttribute;
    public boolean visibleButtonIsVisible;


}
