package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Links {
    LinksElements linksElements = new LinksElements();
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
}
