package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BrokenLinksImages {
    BrokenLinksImagesElements brokenElements = new BrokenLinksImagesElements();
    SoftAssert softAssert = new SoftAssert();
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

    }
    @Test
    public void test02() {

    }
    @Test
    public void test03() {

    }
    @Test
    public void test04() {

    }

    }
