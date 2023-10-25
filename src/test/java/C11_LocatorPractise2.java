import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_LocatorPractise2 {
    /*
   //Navigate to website  https://testpages.herokuapp.com/styled/index.html
   //Under the Examples
   //Click on Locators - Find By Playground Test Page
   //Print the URL
   //Navigate back
   //Print the URL
   //Click on WebDriver Example Page
   //Print the URL
   //Enter value  20 and Enter to "Enter Some Numbers inputBox"
   //And then verify 'two, zero' message is displayed
   //Close driver.
    */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");//Navigate to website  https://testpages.herokuapp.com/styled/index.html
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void webElementMethods1() throws InterruptedException {
        //Under the Examples
        //Click on Locators - Find By Playground Test Page
        driver.findElement(By.xpath("//a[@id='findbytest']")).click();
        //tag'i a olup "id" attribute'unun değeri 'findbytest' olan webelemente tıkla.

        Thread.sleep(2000);

        //Print the URL
        System.out.println("LocatorsUrl :" + driver.getCurrentUrl() );

        //Navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        //Print the URL
        System.out.println("homeUrl :" + driver.getCurrentUrl() );

        //Click on WebDriver Example Page  xpath : //a[@id = 'webdriverexamplepage']
        driver.findElement(By.xpath("//a[@id='webdriverexamplepage']")).click();
        //tag'i a olup "id" attribute'unun değeri 'webdriverexamplepage' olan webelemente tıkla.

        Thread.sleep(2000);

        //Print the URL
        System.out.println("webdriverexamplepageUrl :" + driver.getCurrentUrl() );

        //Enter value  20 and Enter
        driver.findElement(By.xpath("//input[@id='numentry']")).sendKeys("20" + Keys.ENTER);
        //tag'i input olup "id" attribute'unun değeri 'numentry' olan webelemente 20 yaz ve Enterla.

        Thread.sleep(2000);

        //And then verify 'two, zero' message is displayed
        boolean verify1 = driver.findElement(By.xpath("//p[@id='message']")).isDisplayed();
        boolean verify2 = driver.findElement(By.xpath("//*[text()='two, zero']")).isDisplayed();
        Assert.assertTrue(verify1);
        Assert.assertTrue(verify2);
        // Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

        /*
        //tagname[.='text name’]  -> //p[.='Submitted Values']
        //*[contains(text(),'piece of text’)]
        //*[text( )= 'text name’]  -> //*[text()='Submitted Values']
        //*[.='text name’]   -> //*[.='Submitted Values']
         */
    }
}

