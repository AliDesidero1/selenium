import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class C48_FileDownload extends TestBase {
    //    Go to URL: https://the-internet.herokuapp.com/download
    //    Download selenium-snapshot.png
    //    Verify if the file downloaded successfully.
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement seleniumSnap = driver.findElement(By.linkText("selenium-snapshot.png"));
        seleniumSnap.click(); // dosya inmeye basliyicak bu linke tiklandiginda ..
        Thread.sleep(2000);

        String path = System.getProperty("user.home") + System.getProperty("file.separator") + "Downloads" +
                System.getProperty("file.separator") + "selenium-snapshot.png";

        Assert.assertTrue(Files.exists(Paths.get(path)));
    }

    @Test
    public void testAll() {
        driver.get("https://the-internet.herokuapp.com/download");

        List<WebElement> downloadList = driver.findElements(By.tagName("a"));
    }
}

