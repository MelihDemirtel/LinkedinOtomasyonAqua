package elementsExamples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class MouseButtons {
    MouseButtonsElements mouseButtonsElements = new MouseButtonsElements();
    @BeforeClass
    public static void SetUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://demoqa.com");
    }
    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
    @Test
    public void test01() {
        mouseButtonsElements.elementsButton.shouldHave(Condition.visible);
        mouseButtonsElements.elementsButton.shouldBe(Condition.interactable);
        mouseButtonsElements.elementsButton.click();
    }
    @Test
    public void test02() {
        mouseButtonsElements.buttonsButton.shouldHave(Condition.visible);
        mouseButtonsElements.buttonsButton.shouldBe(Condition.interactable);
        mouseButtonsElements.buttonsButton.click();
    }
    @Test
    public void test03() {
        mouseButtonsElements.doubleClickBtn.shouldBe(Condition.interactable);
        mouseButtonsElements.doubleClickBtn.doubleClick();
        mouseButtonsElements.actualDoubleClickMessage.shouldHave(Condition.visible);
        System.out.println(mouseButtonsElements.actualDoubleClickMessage.getText());
        Assert.assertEquals(mouseButtonsElements.actualDoubleClickMessage.getText(), mouseButtonsElements.expectedDoubleClickMessage);
    }
    @Test
    public void test04() {
        mouseButtonsElements.rightClickBtn.shouldBe(Condition.interactable);
        mouseButtonsElements.rightClickBtn.contextClick();
        mouseButtonsElements.actualRightClickMessage.shouldHave(Condition.visible);
        System.out.println(mouseButtonsElements.actualRightClickMessage.getText());
        Assert.assertEquals(mouseButtonsElements.actualRightClickMessage.getText(), mouseButtonsElements.expectedRightClickMessage);
    }
    @Test
    public void test05() {
        mouseButtonsElements.dynamicClickBtn.shouldBe(Condition.interactable);
        mouseButtonsElements.dynamicClickBtn.click();
        mouseButtonsElements.actualDynamicClickMessage.shouldHave(Condition.visible);
        System.out.println(mouseButtonsElements.actualDynamicClickMessage.getText());
        Assert.assertEquals(mouseButtonsElements.actualDynamicClickMessage.getText(), mouseButtonsElements.expectedDynamicClickMessage);
    }
}
