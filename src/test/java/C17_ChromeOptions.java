import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C17_ChromeOptions {

//ChromeOptions Class
//Selenium WebDriver'da Chrome sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.
//start-maximized: Chrome'u büyütme modunda açar.
//incognito: Chrome'u gizli modda açar.
//headless: Chrome'u görüntülenmeyen modda çalıştırır.(headless modda)
//disable-extensions: Chrome tarayıcısında mevcut uzantıları devre dışı bırakır.
//disable-popup-blocking: Chrome tarayıcısında görüntülenen açılır pencereleri devre dışı bırakır.
//make-default-browser: Chrome'u varsayılan tarayıcı yapar.
//version: Chrome tarayıcı sürümünü yazdırır.
//disable-infobars: Chrome'un "Chrome otomatik yazılım tarafından kontrol ediliyor" bildirimini görüntülemesini engeller.

    static WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("start-maximized");// bu kod satiri olmazsa default olarak kucuk halde pencere açar..
        options.addArguments("headless"); // headless modda calistirir ..
        options.addArguments("disable-popup-blocking");// çerezleri block eder ...
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
        Thread.sleep(2000);

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }// Close driver...


}
