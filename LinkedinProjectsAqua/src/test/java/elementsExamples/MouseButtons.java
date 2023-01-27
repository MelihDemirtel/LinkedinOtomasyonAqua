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
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
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
        mouseButtonsElements.elementsButton.shouldBe(Condition.interactable);
        mouseButtonsElements.elementsButton.click();
    }
    @Test
    public void test02() {
        mouseButtonsElements.buttonsButtons.shouldBe(Condition.interactable);
        mouseButtonsElements.buttonsButtons.click();
    }
    @Test
    public void test03() {
        mouseButtonsElements.doubleClickBtn.doubleClick();
        System.out.println(mouseButtonsElements.actualDoubleClickMessage.getText());
        mouseButtonsElements.actualDoubleClickMessage.shouldBe(Condition.visible);
        Assert.assertEquals(mouseButtonsElements.actualDoubleClickMessage.getText(), mouseButtonsElements.expectedDoubleClickMessage);
    }
    @Test
    public void test04() {
        mouseButtonsElements.rightClickBtn.contextClick();
        System.out.println(mouseButtonsElements.actualRightClickMessage.getText());
        mouseButtonsElements.actualRightClickMessage.shouldBe(Condition.visible);
        Assert.assertEquals(mouseButtonsElements.actualRightClickMessage.getText(), mouseButtonsElements.expectedRightClickMessage);
    }
    @Test
    public void test05() {
        mouseButtonsElements.clickBtn.click();
        System.out.println(mouseButtonsElements.actualDynamicClickMessage.getText());
        mouseButtonsElements.actualDynamicClickMessage.shouldBe(Condition.visible);
        Assert.assertEquals(mouseButtonsElements.actualDynamicClickMessage.getText(), mouseButtonsElements.expectedDynamicClickMessage);
    }
}
