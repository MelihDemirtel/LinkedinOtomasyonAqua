package elementsExamples;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UploadDownloadElements {
    //ELEMENTS
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement upDwnButton = $x("//span[text()='Upload and Download']");
    public SelenideElement downloadButton = $(By.id("downloadButton"));
    public SelenideElement uploadButton = $(By.id("uploadFile"));
    public SelenideElement uploadedFileName = $(By.id("uploadedFilePath"));

    //OTHER
    public File file;
    public String downloadUrl;
    public String downloadedFilePath = "C:\\Users\\ext02d47194\\Downloads\\";
    public String actualFileName;
    public String expectedFileName = "C:\\fakepath\\sampleFile.txt";


}
