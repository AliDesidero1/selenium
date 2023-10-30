package HomeWorks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HMW12_WindowHandle_Hepsiburada  {
    // https://www.hepsiburada.com/ adresine gidin
    // Sayfanın windowhandle değerini alın.
    // iphone kelimesini aratın
    // Sonuçlar arasından 3.ürünün fiyatını alın
    // Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
    // Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
    // Herbir ürün sekmesindeki title'ı yazdırın
    // Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
    // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın

    static WebDriver driver;
    static String product3priceOnPage;

    @BeforeClass
    public static void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }
    @Test
    public void test() throws InterruptedException {
        // https://www.hepsiburada.com/ adresine gidin
        driver.get("https://www.hepsiburada.com/");

        Thread.sleep(3000);
        WebElement kabulEt = driver.findElement(By.xpath("//*[.='Kabul et']"));
        kabulEt.click();

        //Sayfanın windowhandle değerini bir değişkene atayın.
        String mainWindowHandle = driver.getWindowHandle();

        //iphone kelimesini aratın
        WebElement searchBox = driver.findElement(By.xpath("//div[@style='justify-content:flex-start']"));
        searchBox.click();
        WebElement inputSearchBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputSearchBox.sendKeys("iphone"+ Keys.ENTER);

        //Sonuçlar arasından 3.ürünün fiyatını alın
        String product3name = driver.findElement(By.xpath("(//h3)[3]")).getText();
        String product3price = driver.findElement(By.xpath("(//div[@data-test-id='price-current-price'])[3]")).getText();
        String product3priceKurussuz = product3price.substring(0,6);

        //Arama sonucunda ortaya çıkan tüm ürünleri teker teker tıklayın
        List<WebElement> productList = driver.findElements(By.xpath("//li[@type='comfort']"));
        System.out.println(productList.size());

        for (int i=0; i<productList.size(); i++) {
            productList.get(i).click();
        }

        //Tüm sekmelerin windowhandle değerlerini alt alta yazdırın
        ArrayList<String> productsWindowHandlesList = new ArrayList<>(driver.getWindowHandles());

        for(int i=0; i<productsWindowHandlesList.size(); i++) {
            System.out.println(productsWindowHandlesList.get(i));
        }

        //Herbir ürün sekmesindeki title'ı yazdırın
        //Arama sonucundaki 3.ürünün fiyatının, aynı ürünün sekmesindeki fiyatla aynı olduğunu doğrulayın
        for(int i=0; i<productsWindowHandlesList.size(); i++) {
            driver.switchTo().window(productsWindowHandlesList.get(i));
            System.out.println(driver.getTitle()+" ");

            if(driver.getTitle().contains(product3name)){
                product3priceOnPage = driver.findElement(By.xpath("//span[contains(@data-bind,'currentPriceBeforePoint')]")).getText();
                break;
            }
        }

        Assert.assertEquals(product3priceKurussuz, product3priceOnPage);

        // Ana sayfada iken 3 saniye bekleyip tüm sekmeleri kapatın
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
        driver.quit();
    }
}

