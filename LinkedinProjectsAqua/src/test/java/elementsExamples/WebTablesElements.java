package elementsExamples;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class WebTablesElements {

    public String expectedFirstRowFirstColm = "Cierra";
    public String expectedFirstRowFirstColmSearch = "Alden";
    public String expected4Row22Colm = "Test";
    public String actual4Row22Colm;
    public String actualFirstRowFirstColm;
    public String expectedFirstRowFirstColmDelete = "Kierra";
    public String actualFirstRowFirstColmDelete;
    public String firstName = "Test";
    public String lastName = "Deneme";
    public String email = "test@deneme.com";
    public String age = "30";
    public String salary = "35000";
    public String department = "Bank";
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement webTablesButton = $x("//span[text()='Web Tables']");
    public ElementsCollection rows = $$(By.className("rt-td"));
    public SelenideElement searchBox = $(By.id("searchBox"));
    public SelenideElement noRows = $x("//*[contains(text(),'No rows')]");
    public SelenideElement addButton = $(By.id("addNewRecordButton"));
    public SelenideElement firstNameLabel = $(By.id("firstName"));
    public SelenideElement lastNameLabel = $(By.id("lastName"));
    public SelenideElement emailLabel = $(By.id("userEmail"));
    public SelenideElement ageLabel = $(By.id("age"));
    public SelenideElement salaryLabel = $(By.id("salary"));
    public SelenideElement departmentLabel = $(By.id("department"));
    public SelenideElement submitButton = $(By.id("submit"));
    public SelenideElement fourthRow = $x("(//div[@role='row'])[5]");
    public SelenideElement deleteButton1 = $(By.id("delete-record-1"));
    public SelenideElement deleteButton2 = $(By.id("delete-record-2"));


}
