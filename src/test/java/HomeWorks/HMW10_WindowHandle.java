package HomeWorks;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static HomeWorks.HMW01_Locators.driver;

public class HMW10_WindowHandle extends TestBase {
    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”

    @Test
    public void testWindowHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement verifyHeader = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(verifyHeader.isDisplayed());
        Assert.assertEquals("Opening a new window", verifyHeader.getText());

        Assert.assertEquals("The Internet", driver.getTitle());

        String mainPageId = driver.getWindowHandle(); // sayfanin handle degeri geri donus icin saklandi

        driver.findElement(By.xpath("//a[contains(.,'Click')]")).click(); // click here butonuna tiklandi

/*        Set<String> windowHandles = driver.getWindowHandles(); // sayfalarin window handle degerleri Set'e atildi
        Iterator<String> i = windowHandles.iterator(); // Tekrara alindi
        while (i.hasNext()){
            String currentHandle = i.next();
            driver.switchTo().window(currentHandle);
            if (driver.getTitle().equals("New Window")){ // Tekrar icinde new window title'i bulundugunda dongu kirildi
                Assert.assertEquals("New Window", driver.getTitle()); // Dogrulamasi yapildi
                break;
            }
        }*/
        Assert.assertEquals("The Internet",driver.switchTo().window(mainPageId).getTitle()); // ilk alinan handle degeriyle sayfanin title'i dogrulandi

        //2.Yol
        List<String> whlist = new ArrayList<>(driver.getWindowHandles());

        for(String wh : whlist){
            if(!mainPageId.equals(wh)){
                driver.switchTo().window(wh);
                break;
            }
        }
        Assert.assertEquals("New Window",driver.getTitle());
    }
}

