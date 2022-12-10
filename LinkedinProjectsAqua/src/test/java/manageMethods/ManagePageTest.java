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
    @BeforeClass
    public static void setUpAll() throws InterruptedException {
        Configuration.browserSize = "1050x660"; //Browser açılış büyüklüğünü ayarlıyoruz.
        Configuration.browserPosition = "200x14"; //Browser açılış konumunu ayarlıyoruz.
        SelenideLogger.addListener("allure", new AllureSelenide());
        Thread.sleep(2000);//2 Saniye bekliyoruz.

        /*Browser konumunu ayarlıyoruz. null yaparsak default olarak 10x10 konumunda açılır.
        Configuration.browserPosition = null;
        */
    }
    @BeforeMethod
    public void setUp() {
        //Bu ayarları setUpAll bölümünde bir defa ayarlamak yeterli. Ben uygulama oalrak görünebilmesi için buraya ikinci defa yazdım.
        //Browserı tam ekran yapıyoruz. Bilgisayarınızın max çözünürlük ayarını yazabilirsiniz.
        Configuration.browserSize = "1296x696";
        //Browser konumunu ayarlıyoruz. null yaparsak default olarak 10x10 konumunda açılır.
        Configuration.browserPosition = "0x0";

        open("https://demoqa.com");
    }
    @AfterClass
    public void tearDown(){ closeWebDriver();}

    @Test
    public void managePage() {
        //Setup kısmında ayarladığımız verileri yazdırıyoruz.
        System.out.println("Current Size: "+Configuration.browserSize);
        System.out.println("Current Position: "+Configuration.browserPosition);
    }
}
