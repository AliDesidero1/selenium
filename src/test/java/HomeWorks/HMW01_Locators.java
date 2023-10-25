package HomeWorks;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HMW01_Locators {
    /*
   //ders sunusundaki webelementleri https://www.linkedin.com/ sayfasinda locate alma
   //id, name, className, linkTest, PLinkTest
    */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.linkedin.com/");
    }
    @Test
    public void id(){
        WebElement id = driver.findElement(By.id("session_key"));
        System.out.println("id = " + id);
    }
    @Test
    public void name(){
        WebElement name = driver.findElement(By.name("session_key"));
        System.out.println("name = " + name);
    }
    @Test
    public void className(){
        //Linked in logosu
        WebElement className = driver.findElement(By.className("linkedin-text"));
        System.out.println("className = " + className);
    }
    @Test
    public void linkTest(){
        WebElement link = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        System.out.println("link bulundu");
    }
    @Test
    public void pLinkTest(){
        WebElement p_link = driver.findElement(By.partialLinkText("Şifrenizi"));
        System.out.println("link bulundu");
    }
}

        //button[contains(text(),'Oturum')]
//button[@type='submit']
// By.linkText("Şifrenizi mi unuttunuz?");
// By.partialLinkText("Şifrenizi");

