package CH3CodeChallange.Day2;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07Faker {
    /*
1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/data-types.html”
3)Fill form
4)Verify alert access 10,danger empty
  */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        driver.get(
                "https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
        Faker faker=new Faker();
        driver.
                findElement(By.xpath("//input[@name='first-name']")).
                sendKeys(faker.name().firstName());
        Thread.sleep(2000);
        driver.
                findElement(By.name("last-name")).
                sendKeys(faker.name().lastName());
        driver.
                findElement(By.xpath("//input[@name='address']")).
                sendKeys(faker.address().fullAddress());
        Thread.sleep(2000);
        driver.
                findElement(By.xpath("//input[@name='zip-code']")).
                sendKeys(faker.address().zipCode());
        Thread.sleep(2000);
        driver.
                findElement(By.xpath("//input[@name='city']")).
                sendKeys(faker.address().city());
        driver.
                findElement(By.xpath("//input[@name='country']")).
                sendKeys(faker.address().country());
        driver.
                findElement(By.xpath("//input[@name='e-mail']")).
                sendKeys(faker.internet().emailAddress());
        driver.
                findElement(By.xpath("//input[@name='phone']")).
                sendKeys(faker.phoneNumber().phoneNumber());
        driver.
                findElement(By.xpath("//input[@name='job-position']")).
                sendKeys(faker.job().position());
        driver.
                findElement(By.xpath("//input[@name='company']")).
                sendKeys(faker.company().name());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(2000);
        List<WebElement> alertSucces=driver.findElements(By.xpath("//div[@class='alert py-2 alert-success']"));
        Assert.assertEquals(10, alertSucces.size());
        List<WebElement>alertDanger=driver.findElements(By.name("alert py-2 alert-danger"));
        Assert.assertTrue(alertDanger.isEmpty());
    }
//    @AfterClass
//    public static void tearDown() {
//        driver.close();
//    }
}