package elementsExamples;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.net.HttpURLConnection;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class BrokenLinksImagesElements {
    //ELEMENTS
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement brokenLinksButton = $x("//span[@class='text' and contains(text(),'Broken')]");
    public String url;
    public String urlText;
    public String imageUrl;
    public String imageUrlText;

    //OTHER
    public ElementsCollection images = $$(By.tagName("img"));
    public ElementsCollection links = $$(By.tagName("a"));

    //HTTP
    public HttpURLConnection connection;
    public int responseCodeImg;
    public int responseCodeLink;
}
