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
        linksElements.elementsButton.shouldHave(Condition.visible);
        closeWindow();
        Selenide.switchTo().window(linksElements.parentId);
        Thread.sleep(1000);
    }
    @Test
    public void test04() throws InterruptedException {
        for (int i = 2; i < linksElements.links.size(); i++){
            linksElements.url = linksElements.links.get(i).getAttribute("href");
            linksElements.urlText = linksElements.links.get(i).getText();
            Thread.sleep(250);
            try{
                linksElements.connection = (HttpURLConnection) new URL(linksElements.url).openConnection();
                linksElements.connection.setRequestMethod("HEAD");
                linksElements.connection.connect();
                linksElements.responseCode = linksElements.connection.getResponseCode();
                System.out.println("URL: " + linksElements.url + " | " + "Returned Response Code: " + linksElements.responseCode + " | " + "URL Text: " + linksElements.urlText);
            }catch (IOException e){
                System.out.println("Error Checking Response Code for URL: " + linksElements.url + " | " + "Returned Response Code: " + linksElements.responseCode + " | " + "URL Text: " + linksElements.urlText);
            }
        }
    }
}
/*
Java'da, koleksiyonlar verilerin toplu olarak saklanmasını ve yönetilmesini sağlayan nesne yapılarıdır.
Koleksiyonlar, çeşitli veri türlerini saklamak için kullanılan farklı tasarımlar içerir ve
verilere hızlı erişim, sıralama, filtreleme, arama ve çok daha fazlasını sağlar.
--------------------------------------------------------------
Set ve List sınıfları Java'da koleksiyonlar için kullanılan veri yapılarıdır. Ancak aralarında önemli farklılıklar vardır:
Eleman eşsizliği: Set sınıfı elemanların eşsiz olduğunu garantiler, yani aynı eleman birden fazla kez bulunmaz.
List sınıfı ise elemanların tekrar edebileceğini garantiler.
Sıralı olma: Set sınıfı elemanlarının sıralı olma garantisi yoktur, ancak List sınıfı elemanların belirli bir sıralama garantisi verir.
Performans: Set sınıfının eleman arama işlemleri daha hızlıdır, ancak eleman ekleme ve silme işlemleri List sınıfından daha yavaştır.
Yukarıdaki farklılıklar dikkate alınarak, Set ve List sınıflarının hangi durumda kullanılması gerektiği belirlenir.
--------------------------------------------------------------
Iterator<String> bir Java veri yapısıdır ve belirtilen bir veri kümesinde (örneğin List, Set vb.) bulunan nesneleri tanımlar ve gezmek için kullanılır.
Iterator özelliği sayesinde, bir veri kümesindeki tüm nesnelere tek tek erişilebilir ve işlenebilir.
Örneğin, bir List<String> veri kümesindeki tüm elemanlar Iterator aracılığıyla tek tek gezilebilir ve işlenebilir.
--------------------------------------------------------------
Java'da next() metodu bir iterator nesnesinde bulunan verileri sırayla dolaşmak için kullanılır.
Bu metod her çağırıldığında iterator nesnesinin içindeki sonraki elemanı döndürür.
Eğer daha fazla eleman yoksa, metod NoSuchElementException istisnası fırlatır.
--------------------------------------------------------------
Tarayıcıda bulunan tüm pencerelerin ID'leri bir "Set<String>" olarak tanımlanır ve "windows" adında bir değişkene atanır.
Bu set içerisindeki verilerin iterasyonunu yapmak için bir "Iterator<String>" tanımlanır ve "it" adında bir değişkene atanır.
Iterator ile set içerisindeki ilk pencerenin ID'si "parentId" değişkenine atanır.
Iterator ile set içerisindeki ikinci pencerenin ID'si "childId" değişkenine atanır.
Tarayıcı, "driver.switchTo().window(childId)" ile "childId" değişkeninde bulunan pencereye geçirilir.
--------------------------------------------------------------
HttpURLConnection, Java programlama dillerinde, HTTP protokolü üzerinden veri transferi yapmak için kullanılan bir API'dir.
HttpURLConnection sınıfı, URL verilerini okumak veya göndermek için HTTP protokolünü kullanır.
HttpURLConnection sınıfı, URL nesnesinin openConnection() metodu ile oluşturulur ve setRequestMethod() metodu ile istek türü
(örneğin GET veya POST) belirtilir. Son olarak, connect() metodu ile bağlantı kurulur ve getResponseCode() metodu ile dönen cevap kodu okunabilir.
--------------------------------------------------------------
Bu kod, "links" adlı WebElement listesindeki her bir link üzerinde döngü oluşturur.
Her bir döngü iterasyonunda, bir linkin URL'si "url" değişkenine atanır ve bir HTTP bağlantısı oluşturulur.
Bağlantı, "HEAD" metodu ile yapılır ve bağlantı "connect" metodu ile başlatılır.
Bağlantının yanıt kodunu "responseCode" değişkenine atanır ve konsol üzerinde ekrana "URL: [URL] returned response code: [yanıt kodu]" şeklinde yazdırılır.
Eğer bağlantı sırasında bir IOException oluşursa, konsol üzerinde "Error checking response code for URL: [URL]" şeklinde bir hata mesajı yazdırılır.
--------------------------------------------------------------
"HEAD" metodu, HTTP protokolünde kullanılan bir istek türüdür.
Bu metodun amacı, sunucudan belirtilen URL'nin üst bilgilerini (metadata) almaktır.
HEAD isteği sunucuya gönderilir ve sunucu tarafından yanıt verilir, ancak sunucunun belirtilen URL'ye ait içerik döndürmemesi beklenir.
Bu, GET isteğinden farklı olarak, sadece URL'nin üst bilgilerinin alınmasını sağlar ve sunucuya istemci tarafından veri indirilmesi için fazla yük bindirmez.
 */