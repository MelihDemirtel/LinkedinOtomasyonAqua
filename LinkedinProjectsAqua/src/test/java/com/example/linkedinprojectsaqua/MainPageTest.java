package com.example.linkedinprojectsaqua;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    public int milis = 2000;
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://demoqa.com");
    }

    @Test
    public void homePage() {
        System.out.println("Sayfa Title: "+title());//Açık sayfanın ismini verir
        System.out.println("Açık Sayfa URL'i: "+webdriver().driver().url());//Açık sayfanın url'ini verir

        System.out.println("Açık Sayfanın Hash Code'u: "+webdriver().driver().hashCode());//Açık Sayfanın Hash Code'unu verir

        System.out.println("=================================");
        System.out.println("Kaynak Kod: "+webdriver().driver().source());//Sayfanın kaynak kodunu verir.
        System.out.println("=================================");
    }
    @Test
    public void elements() {
        mainPage.elementsButton.click();
        sleep(milis);
    }
    @Test
    public void forms() {
        mainPage.formsButton.click();
        sleep(milis);
    }
}
