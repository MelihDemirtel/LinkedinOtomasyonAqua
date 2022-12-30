package locators;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Locators {
    public int milis = 2000;
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1296x696";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        open("https://demoqa.com");
        Thread.sleep(milis);
    }

    @AfterClass
    public void tearDown(){ closeWebDriver();}

    @Test
    public void navigatePage() throws InterruptedException {
        open("https://demoqa.com/elements");
    }
}
