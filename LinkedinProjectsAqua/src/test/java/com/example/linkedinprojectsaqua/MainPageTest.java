package com.example.linkedinprojectsaqua;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;


public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://demoqa.com");
    }

    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    public void homePage() {
        System.out.println("Sayfa Başlığı :" + title() );
        System.out.println("Sayfa URl :" + webdriver().driver().url());

        System.out.println("Hash Code: " + webdriver().driver().hashCode());

        System.out.println("Kaynak Kod: " + webdriver().driver().source());

    }
}