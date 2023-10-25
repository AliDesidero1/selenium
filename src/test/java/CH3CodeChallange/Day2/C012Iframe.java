package CH3CodeChallange.Day2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C012Iframe {
    static WebDriver driver;
    /*
     https://bonigarcia.dev/selenium-webdriver-java/iframes.html adresine gidin
     Paragraf sayısının 20 adet oldugunu dogrulayın
    */
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/iframes.html");
/*
ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe") ifadesi,
"my-iframe" adındaki bir iframe'in yüklendiğini bekler. İframe kullanılabilir hale geldiğinde,
bu ifade WebDriver'ın bu iframe'e geçiş yapmasını sağlar.
Bu, iframe içeriğine erişmek ve işlem yapmak için kullanışlıdır.
*/
        /*
ExpectedConditions.numberOfElementsToBeMoreThan(pName, 0) ifadesi,
sayfadaki bir veya daha fazla web öğesinin (HTML öğeleri)
varlığını bekler. pName bir By nesnesi olmalıdır ve
bu nesnenin temsil ettiği öğelerin sayısının 0'dan fazla olduğunu kontrol eder.
Yani, pName ile belirtilen türdeki web öğelerinin sayısı 0'dan fazla olduğunda
bekleme işlemi sona erer ve test devam eder.
*/
    }
//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}

