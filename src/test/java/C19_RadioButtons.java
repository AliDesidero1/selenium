import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C19_RadioButtons { /*
        Go to URL:  https://www.facebook.com/
        Click on Create an Account button.
        Then click on the radio buttons.
         */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }//Close driver.

    @Test
    public void test() throws InterruptedException {
        WebElement yeniHesap = driver.findElement(By.xpath("//a[starts-with(@id,'u_')]"));
        yeniHesap.click();

        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//label[.='Erkek']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

        if(!female.isSelected()){
            female.click();
        }
        Thread.sleep(3000);

        Assert.assertTrue(female.isSelected());
        Assert.assertFalse(male.isSelected());
        Assert.assertTrue(!custom.isSelected());

    }
}

