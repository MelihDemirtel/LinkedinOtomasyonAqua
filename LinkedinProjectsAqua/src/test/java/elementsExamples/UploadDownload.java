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
    UploadDownloadElements elements = new UploadDownloadElements();
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public static void SetUpAll() {
        Configuration.browserSize = "1910x1020";
        Configuration.timeout = 20000;
        Configuration.downloadsFolder = "C:\\Users\\ext02d47194\\Downloads\\";
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
        elements.downloadedFileName = elements.downloadButton.getAttribute("download");
        elements.downloadButton.click();
        Thread.sleep(elements.milis);
        elements.file = new File(elements.downloadedFileName);
        Thread.sleep(elements.milis);
        if (elements.file.getName() == elements.actualDownloadedFileName) {
            System.out.println("Dosya indirme işlemi başarılıdır");
            System.out.println("İndirilen Dosya Adı: " + elements.file.getName());
        } else {
            System.out.println("Dosya adı hatalıdır");
            System.out.println("İndirilen Dosya Adı: " + elements.file.getName());
        }
        elements.file.delete();
    }
    @Test
    public void test04() throws InterruptedException {
        elements.uploadButton.sendKeys("C:\\Users\\ext02d47194\\Downloads\\sampleFile.txt");
        Thread.sleep(elements.milis);
        elements.uploadedFileName.shouldHave(Condition.visible);
        elements.actualFileName = elements.uploadedFileName.getText();
        softAssert.assertEquals(elements.actualFileName, elements.expectedFileName);
    }

    }
