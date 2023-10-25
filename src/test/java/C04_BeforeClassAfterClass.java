import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_BeforeClassAfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("beforeclass metodu çalıştı");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        System.out.println("Afterclass metodu çalıştı");
    }

    @Test
    public void test1(){
        driver.get("https://www.n11.com/");
        System.out.println("test1 çalıştı");
    }

    @Test
    public void test2(){
        driver.get("https://amazon.com/");
        System.out.println("test2 çalıştı");
    }
}

        //-> 5 test methodu,1 Before Class, 1 After Class,1 After ve 1 Before Methodum var , cevap:17

