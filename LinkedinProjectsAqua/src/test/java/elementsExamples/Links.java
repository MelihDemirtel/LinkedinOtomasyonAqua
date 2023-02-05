package elementsExamples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;

public class Links {
    LinksElements linksElements = new LinksElements();
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
        linksElements.elementsButton.click();
    }
    @Test
    public void test02() {
        linksElements.linksButton.click();
    }
    @Test
    public void test03() throws InterruptedException {
        linksElements.homeLink.click();
        linksElements.windows = Selenide.webdriver().object().getWindowHandles();
        linksElements.window = linksElements.windows.iterator();
        linksElements.parentId = linksElements.window.next();
        linksElements.childIdOne = linksElements.window.next();
        Selenide.switchTo().window(linksElements.childIdOne);
        linksElements.elementsButton.shouldHave(Condition.visible).wait(5000);
        closeWindow();
        Selenide.switchTo().window(linksElements.parentId);
    }
    @Test
    public void test04() {
        for (int i = 4; i < linksElements.links.size(); i++) {
            linksElements.url = linksElements.links.get(i).getAttribute("href");
            linksElements.urlText = linksElements.links.get(i).getText();
            try {
                linksElements.connection = (HttpURLConnection) new URL(linksElements.url).openConnection();
                linksElements.connection.setRequestMethod("HEAD");
                linksElements.connection.connect();
                linksElements.responseCode = linksElements.connection.getResponseCode();
                System.out.println("URL: " + linksElements.url + " | " + "Returned Response Code: " + linksElements.responseCode + " | " + "URL Text: " + linksElements.urlText);
            } catch (IOException e) {
                System.out.println("Error Checking Response Code For URL: " + linksElements.url + " | " + "URL Text: " + linksElements.urlText);
            }
        }
    }
}
