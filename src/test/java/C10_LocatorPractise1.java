import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C10_LocatorPractise1 {
    /*
  Create the driver with BeforeClass and make it static inside the class.
  Go to http://www.google.com
  Type "Green Mile" in the search box and print the number of results.
  Type "Premonition" in the search box and print the number of results.
  Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
  Close with AfterClass.
   */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void webElementMethods1() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Green Mile"+ Keys.ENTER); //Type "Green Mile" in the search box and print the number of results.
    }

    @Test
    public void webElementMethods2() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Premonition"+ Keys.ENTER); //Type "Green Mile" in the search box and print the number of results.
    }

    @Test
    public void webElementMethods3() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER); //Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
    }
    @After
    public void print(){
        System.out.println(driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }
    @Before
    public void before(){
        driver.navigate().to("https://www.google.com/");
    }
}
