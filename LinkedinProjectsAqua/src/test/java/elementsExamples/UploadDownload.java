package elementsExamples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class UploadDownload {
    static int milis = 2000;
    UploadDownloadElements elements = new UploadDownloadElements();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void SetUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://demoqa.com");
    }
    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
    @Test
    public void test01() {
        elements.elementsButton.click();
    }
    @Test
    public void test02() {
        elements.upDwnButton.click();
    }
    @Test
    public void test03() throws InterruptedException {
        elements.downloadUrl = elements.downloadButton.getAttribute("href");
        elements.downloadButton.click();
        Thread.sleep(milis);
        elements.file = new File(elements.downloadedFilePath + "sampleFile.jpeg");
        Thread.sleep(milis);
        if (elements.file.exists()) {
            softAssert.assertEquals(elements.file.getName(), "sampleFile.jpeg");
            System.out.println("İndirilen Dosya Adı: " + elements.file.getName());
            System.out.println("Dosya indirme işlemi başarılıdır");
        } else {
            System.out.println("Dosya indirme işlemi başarısızdır");
        }
        elements.file.delete();
    }
    @Test
    public void test04() throws InterruptedException {
        elements.uploadButton.sendKeys("C:\\Users\\ext02d47194\\Downloads\\sampleFile.txt");
        Thread.sleep(milis);
        elements.uploadedFileName.shouldHave(Condition.visible);
        elements.actualFileName = elements.uploadedFileName.getText();
        softAssert.assertEquals(elements.actualFileName, elements.expectedFileName);
    }

    }
