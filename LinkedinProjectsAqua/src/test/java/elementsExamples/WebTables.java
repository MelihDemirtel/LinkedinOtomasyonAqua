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

public class WebTables {
    static String scrollDown = "window.scrollBy(0,350)";//Sayfayı aşağı kaydırabilmek için
    WebTablesElements webTablesElements = new WebTablesElements();
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
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
}
