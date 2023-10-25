import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C27_Alert2 {
     /*
    https://the-internet.herokuapp.com/javascript_alerts
     */

        //Click for JS Alert butonuna tikla
        //I am a JS Alert alertini kabul et
        //JS Confirm butonuna tikla
        //I am a JS Confirm alertini iptal et
        //JS Prompt butonuna tikla
        //I am a JS prompt alertine text yolla ve kabul et

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test() throws InterruptedException {
        //Click for JS Alert butonuna tikla
        WebElement alert1= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alert1.click();

        //I am a JS Alert alertini kabul et
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //JS Confirm butonuna tikla
        WebElement alert2= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        alert2.click();

        //I am a JS Confirm alertini iptal et
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //JS Prompt butonuna tikla
        WebElement alert3= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        alert3.click();

        //I am a JS prompt alertine text yolla ve kabul et
        driver.switchTo().alert().sendKeys("Alertler bizden kaçmaz");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        /*
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("hello");
        alert.getText();
        */
    }
}

