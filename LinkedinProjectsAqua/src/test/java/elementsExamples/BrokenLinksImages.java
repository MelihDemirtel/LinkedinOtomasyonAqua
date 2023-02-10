package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BrokenLinksImages {
    BrokenLinksImagesElements brokenElements = new BrokenLinksImagesElements();
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
        brokenElements.elementsButton.click();
    }
    @Test
    public void test02() {
        brokenElements.brokenLinksButton.click();
    }
    @Test
    public void test03() {
        for (int i = 2; i < brokenElements.images.size(); i++){
            brokenElements.imageUrl = brokenElements.images.get(i).getAttribute("src");
            brokenElements.imageUrlText = brokenElements.images.get(i).getText();
            try {
                brokenElements.connection = (HttpURLConnection) new URL(brokenElements.imageUrl).openConnection();
                brokenElements.connection.setRequestMethod("HEAD");
                brokenElements.connection.connect();
                brokenElements.responseCodeImg = brokenElements.connection.getResponseCode();
                if (brokenElements.responseCodeImg == 200){
                    System.out.println("IMG IS VALID " + brokenElements.imageUrl + " | " + "Response Code: " + brokenElements.responseCodeImg + " | " + "URL Text: " + brokenElements.imageUrlText);
                }else {
                    softAssert.assertTrue(brokenElements.responseCodeImg > 200);
                    System.out.println("IMG IS BROKEN " + brokenElements.imageUrl + " | " + "Response Code: " + brokenElements.responseCodeImg + " | " + "URL Text: " + brokenElements.imageUrlText);
                }
            }catch (IOException e){
                System.out.println("Error URL: " + brokenElements.imageUrl + " | " + "Response Code: " + brokenElements.responseCodeImg + " | " + "URL Text: " + brokenElements.imageUrlText);
            }
        }
    }
    @Test
    public void test04() {
        for (int i = 2; i < brokenElements.links.size(); i++){
            brokenElements.url = brokenElements.links.get(i).getAttribute("href");
            brokenElements.urlText = brokenElements.links.get(i).getText();
            try {
                brokenElements.connection = (HttpURLConnection) new URL(brokenElements.url).openConnection();
                brokenElements.connection.setRequestMethod("HEAD");
                brokenElements.connection.connect();
                brokenElements.responseCodeLink = brokenElements.connection.getResponseCode();
                if (brokenElements.responseCodeLink == 301){
                    System.out.println("LINK IS VALID: " + brokenElements.url + " | " + "Response Code: " + brokenElements.responseCodeLink + " | " + "URL Text: " + brokenElements.urlText);
                }else {
                    softAssert.assertTrue(brokenElements.responseCodeLink > 301);
                    System.out.println("LINK IS BROKEN: " + brokenElements.url + " | " + "Response Code: " + brokenElements.responseCodeLink + " | " + "URL Text: " + brokenElements.urlText);
                }
            }catch (IOException e){
                System.out.println("Error URL: " + brokenElements.url + " | " + "Response Code: " + brokenElements.responseCodeLink + " | " + "URL Text: " + brokenElements.urlText);
            }
        }

    }

    }
