import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C12_LocatorPractise3 {
    /*
       //https://id.heroku.com/login sayfasına gidiniz.
       //Bir mail adresi giriniz.
       //Bir password giriniz.
       //Login butonuna tıklayınız.
       //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
       //Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
       //Tüm sayfaları kapatınız.
        */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("argument name");
        // options.addArguments("disable-popup-blocking");
        driver.get("https://id.heroku.com/login");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void webElementMethods1() throws InterruptedException {
        //Bir mail adresi giriniz.
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("abc@gmail.com");
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com"+Keys.ENTER);
        //tag'i a olup "id" attribute'unun değeri 'email' olan webelementi bul.

        Thread.sleep(2000);

        //Bir password giriniz.
        WebElement passBox = driver.findElement(By.xpath("//input[@id='password']"));

        passBox.sendKeys("abc123"+ Keys.ENTER);

        //Login butonuna tıklayınız.
        //  //*[@name = 'commit']   //*[.='Log In']   //*[@type='submit']

        Thread.sleep(2000);

        //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
        //Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
        WebElement alertText = driver.findElement(By.xpath("//div[contains(text(), 'problem')]"));
        System.out.println(alertText.isDisplayed()? "Kayıt Yapılmadı":"Kayıt Yapıldı");

        Thread.sleep(2000);
    }
}
