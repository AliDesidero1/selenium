import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C16_RelativeLocator {
    /*
    Go to http://www.bestbuy.com
    Verify that the page header contains " Hello" Also,
    using Relative Locator.
    LogoTest  Verify if the BestBuy logo is displayed.
    CanadaLinkTest  Verify if the link is displayed.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }//Close driver.

    @Test
    public void helloTest(){
        WebElement helloHeader = driver.findElement(RelativeLocator.with(By.tagName("div")).below(By.xpath("(//img[@class='logo'])[1]")));
        Assert.assertTrue(helloHeader.isDisplayed());
    }
}