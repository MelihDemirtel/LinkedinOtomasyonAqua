package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;

public class DynamicProperties {
    DynamicPropertiesElements elements = new DynamicPropertiesElements();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void SetUpAll() {
        Configuration.browserSize = "1910x1020";
        Configuration.timeout = 20000;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeMethod
    public void beforeAllTests(){
        open("https://demoqa.com");
        elements.elementsButton.click();
        executeJavaScript(elements.scrollDown);//Sayfa aşağı kaydırılır.
        elements.dynamicPropertiesButton.click();
    }
    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(1000);
        elements.firstRandomIdAttribute = $x("//p[contains(text(),'This text has random Id')]").getAttribute("id");
        System.out.println("firstRandomIdAttribute: " + elements.firstRandomIdAttribute);
        elements.firstRandomIdText = $(By.id(elements.firstRandomIdAttribute));
        softAssert.assertTrue(elements.firstRandomIdText.isDisplayed());
        refresh();
        Thread.sleep(1000);
        elements.secondRandomIdAttribute = $x("//p[contains(text(),'This text has random Id')]").getAttribute("id");
        System.out.println("secondRandomIdAttribute: " + elements.secondRandomIdAttribute);
        elements.SecondRandomIdText = $(By.id(elements.secondRandomIdAttribute));
        softAssert.assertTrue(elements.SecondRandomIdText.isDisplayed());
        softAssert.assertNotEquals(elements.firstRandomIdAttribute, elements.secondRandomIdAttribute);
        softAssert.assertAll();
    }
    @Test
    public void test02() throws InterruptedException {
        elements.enableButtonIsEnable = elements.enableButton.isEnabled();
        softAssert.assertFalse(elements.enableButtonIsEnable);
        System.out.println("STATE enableButtonIsEnable: " + elements.enableButtonIsEnable);
        while (elements.enableButtonIsEnable != true){
            System.out.println("Enable Button Is Not Enable Wait For 5 Seconds");
            Thread.sleep(elements.milis);
            elements.enableButtonIsEnable = elements.enableButton.isEnabled();
        }
        softAssert.assertTrue(elements.enableButtonIsEnable);
        System.out.println("Enable Button Is Active, NOW | " + elements.enableButtonIsEnable);
        softAssert.assertAll();
    }
    @Test
    public void test03() throws InterruptedException {
        elements.firstColorButtonAttribute = elements.colorButton.getAttribute("class");
        System.out.println("firstColorButtonAttribute: " + elements.firstColorButtonAttribute);
        Thread.sleep(elements.milis);
        elements.secondColorButtonAttribute = elements.colorButton.getAttribute("class");
        System.out.println("secondColorButtonAttribute: " + elements.secondColorButtonAttribute);
        softAssert.assertNotEquals(elements.firstRandomIdAttribute, elements.secondRandomIdAttribute);
        softAssert.assertAll();
    }
    @Test
    public void test04() throws InterruptedException {
        Thread.sleep(elements.milis);
        elements.visibleButtonIsVisible = elements.visibleButton.isDisplayed();
        softAssert.assertTrue(elements.visibleButtonIsVisible);
        System.out.println("Visible Button Is Visible, NOW | " + elements.visibleButtonIsVisible);
        softAssert.assertAll();
    }

    }
