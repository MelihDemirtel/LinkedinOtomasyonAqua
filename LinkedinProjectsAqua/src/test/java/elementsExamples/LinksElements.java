package elementsExamples;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

;import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class LinksElements {
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement linksButton = $x("//span[text()='Links']");
    public SelenideElement homeLink = $(By.linkText("Home"));
    public ElementsCollection links = $$(By.tagName("a"));
    public Set<String> windows;
    public Iterator<String> window;
    public String parentId;
    public String childIdOne;
    public String url;
    public String urlText;
    public HttpURLConnection connection;
    public int responseCode;
}
