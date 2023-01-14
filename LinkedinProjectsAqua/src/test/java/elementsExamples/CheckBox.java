package elementsExamples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class CheckBox {
    public String expectedFirstIndexHome = "home";
    public String actualFirstIndexHome;
    int milis = 1000;
   CheckBoxPage checkBoxPage = new CheckBoxPage();
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
    public void checkBoxPage() throws InterruptedException {
        checkBoxPage.elementsButton.click();
        Thread.sleep(milis);

        checkBoxPage.checkBoxButton.click();
        Thread.sleep(milis);

        boolean isSelectedHome = checkBoxPage.checkBoxHomeButton.isSelected();

        if(isSelectedHome){
            System.out.println("CheckBox is already selected");
        }else{
            checkBoxPage.checkBoxHomeButton.click();
            System.out.println("CheckBox is selected now");
        }
        Thread.sleep(milis);

        for (SelenideElement result : checkBoxPage.resultHome){
            System.out.println(result.getText());
        }
        actualFirstIndexHome = checkBoxPage.resultHome.get(0).getText();
        Assert.assertEquals(actualFirstIndexHome, expectedFirstIndexHome);

        checkBoxPage.toggleButton1.click();
        Thread.sleep(milis);

        Assert.assertTrue(checkBoxPage.checkBoxDesktop.isDisplayed());
        Assert.assertTrue(checkBoxPage.checkBoxDocument.isDisplayed());
        Assert.assertTrue(checkBoxPage.checkBoxDownloads.isDisplayed());

        checkBoxPage.checkBoxHomeButton.click();
        Thread.sleep(milis);

        checkBoxPage.checkBoxDesktop.click();
        Thread.sleep(milis);

        if (isSelectedHome){
            System.out.println("CheckBox is already selected");
        }else{
            System.out.println("CheckBox is NOT selected");
        }
    }
}
