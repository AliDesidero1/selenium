import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C24_Waits {
    // bazi siteler, islemeler arasında bekleme süreleri koyar. bundan dolayi bekleme methodlari kulaniriz
    // Selenium wait ler selenium icin kritik bir konsepttir. Senkronize bir sekilde elementleri bulmamizi
    // ve elementnotfound gibi hatalari almamizi engeller.
    // Implicit Wait
    // Explicit Wait *
    // Fluent Wait
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void hardWait(){
        //kosulsuz senkronizasyon-statik bekleme
        //statik bekleme, tek basina zaman asimi degerini gosterir
        //ve aracin yalnizca belirtilen sure doldugunda devam etmesini saglar
        //Java ile selenium da statik beklemeyi saglamak icin Thread.sleep() methodunu kullaniriz

        driver.get("https://seleniumatfingertips.wordpress.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println(e);
        }

        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
    }
    @Test
    public void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MICROSECONDS);
        //30 sn suresince sayfanin yuklenmesini bekliyor, bu sureden sonra sayfa yuklenmezse timeOut duserek hata verir
        //sayfanin belirtilen sure kadar tamamen yuklenmesini bekler..

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Orange"));

    }

    @Test
    public void implicitWait() {
        /* Implicit wait :
       Tüm sayfadaki elemanlar için bir bekleme süresi atanıyor.Ancak eleman bulunduğu anda daha fazla beklemiyor.
       Bütüm elemanlar geçerlidir.NoSuchElement hatasını vermek için verilen süre kadar eleman bulunana kadar bekler.
       globaldir, butun webelementler icin bekler..
         */
        driver.get("https://seleniumatfingertips.wordpress.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Group Test in TestNg yazisinin gorunurlulugunu test ediniz
        WebElement groupTxt = driver.findElement(By.partialLinkText("Group Test"));
        Assert.assertTrue(groupTxt.isDisplayed());
    }

    @Test
    public void explicitWait(){
        /*
        WebDriver'ın beklemesi gereken koşulu ve zamanı belirtir.
        Pratik olarak, WebDriverWait ve explicitly wait,
        tanımları ve kullanımları mükemmel bir şekilde eşleştiğinden eş anlamlıdır.
        //Explicit wait nasil kullanilir
        // 1- WebDriverWait objesi olustur
        // 2- wait objesinin until methoduna istedigin condition u sagla
         */

        driver.get("https://seleniumatfingertips.wordpress.com/");
        //WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement home = driver.findElement(By.linkText("Home"));

        // assumption : kodumuz bu noktada element yukleme durumda oldugundan
        // locate edileblir ancak tiklanmayabilir, bu durumda ElementNotClickable hatasi firlatir..
        //wait objesinin until methoduna istedigimiz condition u saglariz

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //sadece sure tanimlandi, henuz aktif degil
        //15 saniye beklemek zorunda degil, eleman bulundugu anda isleme devam eder.

        wait.until(ExpectedConditions.visibilityOf(home));// görünür olana kadar bekle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));//locate edilene kadar bekle

        //local bir wait turudur, implicitly waitin yetersiz oldugu durumlarda kullanilir..
    }


    @Test
    public void fluentWait(){
        //neredeyse hic kullanilmaz..
        //elementleri belirlenen sure boyunca sarti saglayip saglamadigi kontrol edilir
        //sarti sagladigi anda devam edilir, saglamazsa exception firlatir..

        driver.get("https://seleniumatfingertips.wordpress.com/");
        WebElement home = driver.findElement(By.linkText("Home"));

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))//toplam bekleme süresi sayfa ilk açıldığında
                .pollingEvery(Duration.ofSeconds(20))// YOKLAMA her 20 saniyede varlık kontrolü
                .ignoring(NoSuchElementException.class);// exceptionı görmezden gelir, veya engeller.
        //bir webelementin sayfada bulunabilmesi icin 10 sn bekle, her 20 milisanide bir varligini kontrol et
    }
}