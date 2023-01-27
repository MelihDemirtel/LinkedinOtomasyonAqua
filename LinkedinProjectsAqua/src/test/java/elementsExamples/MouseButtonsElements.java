package elementsExamples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MouseButtonsElements {
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement buttonsButtons = $x("//span[text()='Buttons']");
    public SelenideElement doubleClickBtn = $(By.id("doubleClickBtn"));
    public SelenideElement rightClickBtn = $(By.id("rightClickBtn"));
    public SelenideElement clickBtn = $x("//button[text()='Click Me']");
    public SelenideElement actualDoubleClickMessage = $(By.id("doubleClickMessage"));
    public SelenideElement actualRightClickMessage = $(By.id("rightClickMessage"));
    public SelenideElement actualDynamicClickMessage = $(By.id("dynamicClickMessage"));


    //Strings
    public String expectedDoubleClickMessage = "You have done a double click";
    public String expectedRightClickMessage = "You have done a right click";
    public String expectedDynamicClickMessage = "You have done a dynamic click";





}
