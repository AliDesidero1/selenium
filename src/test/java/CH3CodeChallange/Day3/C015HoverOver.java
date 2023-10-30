package CH3CodeChallange.Day3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C015HoverOver extends TestBase {
    /*
 web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html
Sayfadaki dört farklı görüntüyü (images) temsil eden elementleri tanımlayın.
görüntünün üzerine gelin ve görünen yazıyı alın.
Bu yazının, "compass"olup olmadığını doğrulayın.
İkinci görüntünün üzerine gelin ve görünen yazıyı alın.
Bu yazının, "calendar" olup olmadığını doğrulayın.
Üçüncü ve dördüncü görüntüler için aynı işlemleri tekrarlayın.

*/
    @Test
    public void Test01() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        WebElement compass = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][1]"));
        WebElement calendar = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][2]"));
        WebElement award = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][3]"));
        WebElement landscape = driver.findElement(By.xpath("//div[@class='figure text-center col-3 py-2'][4]"));


        actions.moveToElement(compass).perform();

        // Bekleme süresi için WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement compassCaption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='caption']//p)[1]")));
        String compassText = compassCaption.getText();

        System.out.println("compassText = " + compassText);
        Assert.assertEquals(compassText, "Compass");
    }
}
