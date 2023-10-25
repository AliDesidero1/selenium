package HomeWorks;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HMW02_Locators {
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Print the result

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @Test
    public void id(){

        driver.findElement(By.id("calculatetest")).click();
        // By.xpath("//a[@id='calculatetest']")


        driver.findElement(By.id("number1")).sendKeys("100");  //By.cssSelector("#number1")
        driver.findElement(By.id("number2")).sendKeys("20");  //By.cssSelector("#number2")
        WebElement dropDown = driver.findElement(By.id("function"));
        Select select = new Select(dropDown);
        select.selectByValue("divide");
        select.selectByIndex(3);
        select.selectByVisibleText("divide");

        driver.findElement(By.id("calculate")).click();                  //By.xpath("//input[@type='submit']")
        System.out.println(driver.findElement(By.id("answer")).getText()); //By.xpath("//span[@id='answer']")

        // System.out.println(Integer.parseInt(result));
        // sonucu bir String result a assign edip sayı olarak da yazdırabilirz

        //System.out.println(driver.findElement(By.id("answer")).getText());
    }

}

