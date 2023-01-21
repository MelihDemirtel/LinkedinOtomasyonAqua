package manageMethods;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ManagePageTest {
    static int milis = 1000;
    @BeforeClass
    public static void setUpAll() throws InterruptedException {
        Configuration.browserSize = "1050x660";
        Configuration.browserPosition = "200x14"; //Default değer null 10x10
        SelenideLogger.addListener("allure", new AllureSelenide());
        Thread.sleep(milis);
    }
    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1296x696";
        Configuration.browserPosition = "0x0";

        open("https://demoqa.com");
    }
    @AfterClass
    public void tearDown(){ closeWebDriver();}

    @Test
    public void managePage() {
        System.out.println("Current Size: " + Configuration.browserSize);
        System.out.println("Current Position: " + Configuration.browserPosition);
    }
}
