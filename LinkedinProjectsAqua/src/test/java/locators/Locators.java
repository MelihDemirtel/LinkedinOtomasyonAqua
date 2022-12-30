package locators;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Locators {
    public int milis = 2000;
    public String scrollDown = "window.scrollBy(0,350)";//Sayfayı aşağı kaydırabilmek için

    LocatorsPage locatorsPage = new LocatorsPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1296x696";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        open("https://demoqa.com/login");
        Thread.sleep(milis);
    }

    @AfterClass
    public void tearDown(){ closeWebDriver();}

    @Test
    public void LocatorsPage() throws InterruptedException {
        executeJavaScript(scrollDown);//Sayfa aşağı kaydırılır

        locatorsPage.userNameLabel.sendKeys("NewUser");//Kullanıcı adı girilir
        Thread.sleep(milis);
        locatorsPage.userNameLabelCss.sendKeys("One");//Kullanıcı adı girilir.
        Thread.sleep(milis);
        locatorsPage.passwordLabel.sendKeys("123456");//Şifre girilir
        Thread.sleep(milis);
        locatorsPage.loginButton.click();//Kayıt ol butonuna tıklanır
        Thread.sleep(milis);
        locatorsPage.errorMessage.isDisplayed();//Hata mesajı görüldü mü kontrol edilir
        Thread.sleep(milis);
        locatorsPage.newUserButton.click();//Yeni kullanıcı butonuna tıklanır
        Thread.sleep(milis);
    }
}
