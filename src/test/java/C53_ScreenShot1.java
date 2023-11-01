import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C53_ScreenShot1 extends TestBase {

    // Go to amazon.com.
    // Take Page ScreenShot.
    // Spesific WebElement ScreenShot

    // Take Page ScreenShot.
    @Test
    public void takeFullPageScreenShot() throws IOException {
        driver.get("https://www.amazon.com/");
        //TakesScreenshot interface i ile bir obje olusturdukve ekran goruntusu almak icin getScreenshotAs methodunu kullandik
        TakesScreenshot ts = (TakesScreenshot) driver; //driver i, TakesScreenshot a cast yaptik
        File source = ts.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        File destination = new File(".\\test-output\\Screenshots\\AmazonFullPage"+date+".png");

        FileUtils.copyFile(source,destination);
    }

    // Spesific WebElement ScreenShot
    @Test
    public void takeSpesificWEScreenShot() throws IOException, InterruptedException {
        driver.get("https://www.amazon.com./");
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        File source = amazonLogo.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        File destination = new File(".\\test-output\\Screenshots\\AmazonLogo"+date+".png");

        FileUtils.copyFile(source,destination);
    }
}