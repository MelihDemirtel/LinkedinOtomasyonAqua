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

public class RadioButton {
    static int milis = 2000;
    static String actualRadioButtonPageMessage;
    static String expectedRadioButtonPageMessage = "Do you like the site?";
    static  String actualRadioYesButtonMessage;
    static  String expectedRadioYesButtonMessage = "Yes";
    static  String actualRadioImpressiveButtonMessage;
    static  String expectedRadioImpressiveButtonMessage = "Impressive";
    static boolean isClickableNo;
    RadioButtonPage radioButtonPage = new RadioButtonPage();
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
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void radioButtonPage() throws InterruptedException {
        radioButtonPage.elementsButton.click();
        Thread.sleep(milis);

        radioButtonPage.radioButton.click();
        Thread.sleep(milis);

        actualRadioButtonPageMessage = radioButtonPage.radioButtonPageMessage.getText();
        Assert.assertEquals(actualRadioButtonPageMessage, expectedRadioButtonPageMessage);

        radioButtonPage.radioYesButton.click();
        Thread.sleep(milis);

        actualRadioYesButtonMessage = radioButtonPage.radioYesButtonMessage.getText();
        Assert.assertEquals(actualRadioYesButtonMessage, expectedRadioYesButtonMessage);

        radioButtonPage.radioImpressiveButton.click();
        Thread.sleep(milis);

        actualRadioImpressiveButtonMessage = radioButtonPage.radioImpressiveButtonMessage.getText();
        Assert.assertEquals(actualRadioImpressiveButtonMessage, expectedRadioImpressiveButtonMessage);

        isClickableNo = radioButtonPage.radioNoButton.isEnabled();

        System.out.println("STATE: " + isClickableNo);

        if (isClickableNo){
            System.out.println("No is not clickable");
        }else{
            System.out.println("No is clickable");
        }
    }
}
