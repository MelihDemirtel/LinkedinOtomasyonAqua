package navigateMethods;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NavigateMethods {
    public int milis = 2000;
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
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

        back();//Sayfada geri gelmek için
        Thread.sleep(milis);

        forward();//Sayfada ileri gitmek için
        Thread.sleep(milis);

        refresh();//Sayfayı yenilemek için

        //Refresh metodunu doğrulamak için görselin görünümünü doğruluyoruz.
        $(By.xpath("//img[@src='/images/Toolsqa.jpg']")).shouldHave(visible);

    }
}
