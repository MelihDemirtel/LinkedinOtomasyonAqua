package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TextBox {
    public String expectedValidationText = "Please select an item from left to start practice.";
    public String fullName = "Test";
    public String email = "test@deneme.com";
    public String currentAddress = "deneme caddesi";
    public String permanentAddress = "test deneme";
    public int milis = 2000;
    public String scrollDown = "window.scrollBy(0,350)";//Sayfayı aşağı kaydırabilmek için

    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
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
    public void test1() throws InterruptedException {

        textBoxPage.elementsButton.click();
        Thread.sleep(milis);

        textBoxPage.actualValidationText.isDisplayed();
        Assert.assertEquals(textBoxPage.actualValidationText.getText(), expectedValidationText);

        textBoxPage.textBoxButton.click();
        Thread.sleep(milis);

        textBoxPage.fullNameLabelText.isDisplayed();

        textBoxPage.fullNameLabel.sendKeys(fullName);
        Thread.sleep(milis);
        textBoxPage.emailLabel.sendKeys(email);
        Thread.sleep(milis);
        textBoxPage.currentAddressLabel.sendKeys(currentAddress);
        Thread.sleep(milis);
        textBoxPage.permanentAddressLabel.sendKeys(permanentAddress);
        Thread.sleep(milis);

        textBoxPage.submitButton.click();
        executeJavaScript(scrollDown);//Sayfa aşağı kaydırılır.
        Thread.sleep(milis);

        textBoxPage.resultArea.isDisplayed();
        Assert.assertEquals(textBoxPage.actualName.getText(), "Name:" + fullName);
        Assert.assertEquals(textBoxPage.actualEmail.getText(), "Email:" + email);
        Assert.assertEquals(textBoxPage.actualCurrentAddress.getText(), "Current Address :" + currentAddress);
        Assert.assertEquals(textBoxPage.actualPermanentAddress.getText(), "Permananet Address :" + permanentAddress);
    }

}
