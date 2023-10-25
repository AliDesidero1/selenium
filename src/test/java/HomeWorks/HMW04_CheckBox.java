package HomeWorks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class HMW04_CheckBox {
    /*
Go to URL: https://demoqa.com/
Click on Elements.
Click on Checkbox.
Verify if Home checkbox is selected.
Verify that "You have selected" is visible.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");
        Thread.sleep(1000);

        // Click on Elements.
        WebElement popUp = driver.findElement(By.xpath("//div[@id='adplus-anchor']"));

        driver.findElement(RelativeLocator.with(By.xpath("(//div[@class='card-up'])[1]")).near(popUp)).click();

        // Click on Checkbox.
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        Thread.sleep(1000);

        // Verify if Home checkbox is selected.
        WebElement homeCheckbox = driver.findElement(By.xpath("//span[@class='rct-checkbox']")); // get Home checkbox
        Assert.assertFalse(homeCheckbox.isSelected());  //Verify if Home checkbox is selected.
        Thread.sleep(1000);
        if (!homeCheckbox.isSelected()) homeCheckbox.click(); //Click on Checkbox.
        Thread.sleep(1000);

        // Verify that "You have selected" is visible.
        WebElement youHaveSelected = driver.findElement(By.xpath("//div[@id='result']"));
        Assert.assertTrue(youHaveSelected.isDisplayed());  //passed
    }

}
//Selected Text : yesRadio
//Selected Text : impressiveRadio
//noRadio is not enabled

        //h5[.='Elements']
//span[.='Check Box']
//span[@class='rct-checkbox']
//*[@id='tree-node']/ol/li/span/label/span[1]
//*[.='You have selected :']

