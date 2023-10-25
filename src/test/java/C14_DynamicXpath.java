import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C14_DynamicXpath {
    /*
  interview larda dinamik eleman nedir ? ne nasıl bulursunuz ?
 Sayfa yenilendiğinde id ler veya locator lar değişiyorsa buna dinamik eleman denir.
 Aşağıdaki fonksiyonlar ile bulunur.

 Özet Bilgi
  u_0_f7
  u_1_f7
  u_2_f7
  u_3_f7
  u_4_f7
  u_6_f7

  u_ başlıyor
  _f7 bitiyor

  a[id^='u_'][id$='_f7']


  CSS de
  ^ -> ile başlayan
  $ -> ile biten
  * -> içinde geçen

  cssSelector("input[id^='u_'][id$='_b2']   cssSelector("input[id^='u_'][id$='_Wd']

  Xpath
  //a[starts-with(@id,'u_')] -> ile başlayan
  //a[ends-with(@id,'_f7')]    -> ile biten
  //a[contains(@id,'u_')]    -> içinde geçen
   */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void test1(){
        driver.findElement(By.xpath("(//button[starts-with(@id,'u_')])[3]")).click();//Cookies handle edildi

        //input[@id='email'][@type='text']
        //  (//input[starts-with(@class,'inputtext')])[1] : class attribute u inputtext ile baslayan input tagname indeki 1. indexdeki eleman
        //  //input[contains(@placeholder,'Numarası')]  : placeholder attribute u 'Numarası' ifadesi iceren input tagname indeki eleman
        WebElement emailBox1 = driver.findElement(By.xpath("//input[contains(@placeholder,'Telefon')]"));
        WebElement emailBox2 = driver.findElement(By.xpath("//input[starts-with(@placeholder,'E-posta')]"));
        emailBox1.sendKeys("abc@gmail.com");

        WebElement passBox = driver.findElement(By.xpath("//input[contains(@data-testid, 'pass')]")); // //input[@id= 'pass'] de olurdu..
        passBox.sendKeys("abc@gmail.com");

        WebElement girisYapButton = driver.findElement(By.xpath("//button[starts-with(@id, 'u_')]"));
        //girisYapButton.click();

        WebElement yeniHesap = driver.findElement(By.xpath("//a[starts-with(@id, 'u_')]"));
        yeniHesap.click();
    }
}

