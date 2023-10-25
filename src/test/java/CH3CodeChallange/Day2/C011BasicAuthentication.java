package CH3CodeChallange.Day2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C011BasicAuthentication {
    static WebDriver driver;
    /*
     //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");
        driver.get("https://guest:guest@jigsaw.w3.org/HTTP/Basic/");
Verify body contains "Your browser made it!"
    */
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
    }
//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}

