package CH3CodeChallange.day01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CCHW {
    /*
1) Open the browser
2) Enter the URL "https://hava-durumu-apps.netlify.app/"
3) Enter Istanbul on ınput area
4) Verify result contains Istanbul
  */
    static WebDriver driver;//class seviyesinde tanımlamalıyız

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://hava-durumu-apps.netlify.app/");
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys("Istanbul");

        Thread.sleep(3000);
        WebElement ResultArea=driver.findElement(By.xpath("(//input[@id='input']/following-sibling::div//div)//h2[@class='text-2xl font-semibold mb-3']"));

        Assert.assertEquals("Istanbul", ResultArea.getText());
    }

    @AfterClass
    public static void tearDown() {
        driver.close();

    }
}