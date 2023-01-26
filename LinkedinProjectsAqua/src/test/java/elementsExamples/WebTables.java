package elementsExamples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class WebTables {

    WebTablesElements webTablesElements = new WebTablesElements();
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout= 15000;
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://demoqa.com");
    }

    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }

    @Test
    public void test01() {
        webTablesElements.elementsButton.shouldHave(Condition.visible);
        webTablesElements.elementsButton.click();
    }
    @Test
    public void test02() {
        webTablesElements.webTablesButton.click();
    }
    @Test
    public void test03() {
        webTablesElements.actualFirstRowFirstColm = webTablesElements.rows.get(0).getText();
        Assert.assertEquals(webTablesElements.actualFirstRowFirstColm, webTablesElements.expectedFirstRowFirstColm);
    }
    @Test
    public void test04() {
        webTablesElements.searchBox.sendKeys("al");
        webTablesElements.actualFirstRowFirstColm = webTablesElements.rows.get(0).getText();
        Assert.assertEquals(webTablesElements.actualFirstRowFirstColm, webTablesElements.expectedFirstRowFirstColmSearch);
    }
    @Test
    public void test05() {
        webTablesElements.searchBox.clear();
        webTablesElements.searchBox.sendKeys("zzz");
        webTablesElements.noRows.shouldHave(Condition.visible);
        webTablesElements.searchBox.clear();
    }
    @Test
    public void test06() {
        refresh();
        webTablesElements.addButton.click();
    }
    @Test
    public void test07() {
        webTablesElements.firstNameLabel.sendKeys(webTablesElements.firstName);
        webTablesElements.lastNameLabel.sendKeys(webTablesElements.lastName);
        webTablesElements.emailLabel.sendKeys(webTablesElements.email);
        webTablesElements.ageLabel.sendKeys(webTablesElements.age);
        webTablesElements.salaryLabel.sendKeys(webTablesElements.salary);
        webTablesElements.departmentLabel.sendKeys(webTablesElements.department);

        webTablesElements.submitButton.click();
    }
    @Test
    public void test08() {
        webTablesElements.fourthRow.shouldHave(Condition.visible);
        webTablesElements.actual4Row22Colm = webTablesElements.rows.get(21).getText();
        Assert.assertEquals(webTablesElements.actual4Row22Colm, webTablesElements.expected4Row22Colm);
    }
    @Test
    public void test09() {
        webTablesElements.deleteButton1.click();
        webTablesElements.deleteButton2.click();
    }
    @Test
    public void test10() {
        webTablesElements.actualFirstRowFirstColmDelete = webTablesElements.rows.get(0).getText();
        Assert.assertEquals(webTablesElements.actualFirstRowFirstColmDelete, webTablesElements.expectedFirstRowFirstColmDelete);
    }
    @Test
    public void test11() {
        refresh();
        webTablesElements.fourthRow.shouldHave(Condition.empty);
    }
}
