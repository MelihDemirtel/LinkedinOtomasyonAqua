package elementsExamples;

import com.codeborne.selenide.*;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class LinksElements {
    public SelenideElement elementsButton = $x("//h5[text()='Elements']");
    public SelenideElement linksButton = $x("//span[text()='Links']");
    public SelenideElement homeLink = $(By.linkText("Home"));
    public ElementsCollection links = $$(By.tagName("a"));
    public Set<String> windows;
    public Iterator<String> window;
    public String parentId;
    public  String childIdOne;
    public String url;
    public String urlText;
    public HttpURLConnection connection;
    public int responseCode;
}
