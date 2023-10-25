import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_Xpath {
    //  format : //tagName[@attribute = 'value']

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void byXpath() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
        //    //input[@name = 'field-keywords']   //input[@placeholder= 'Search Amazon']   //input[@aria-label='Search Amazon']
        //tag i input olan  attribute id olan value su twotabsearchtextbox olan webelementi bul
        //tag i input olan  attribute placeholder olan value'su "Search Amazon" olan webelementi bul

        searchBox.sendKeys("iphone15"+ Keys.ENTER);
        Thread.sleep(3000);
    }
}

