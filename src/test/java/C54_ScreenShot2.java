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

public class C54_ScreenShot2 extends TestBase {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Saving the image to  the path.
    //Getting screenshot of Orange HRM Logo.
    //Getting screenshot of  Orange HRM Page Section.

    @Test
    public void testScreenShot() throws IOException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement orangeHRMLogo = driver.findElement(By.xpath("//img[@alt='company-branding']"));

        File source = orangeHRMLogo.getScreenshotAs(OutputType.FILE);

        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        File destination = new File(".\\test-output\\Screenshots\\orangeHRMLogo"+date+".png");

        FileUtils.copyFile(source,destination);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourceFull = ts.getScreenshotAs(OutputType.FILE);

        File destinationFull = new File(".\\test-output\\Screenshots\\orangeHRMfull"+date+".png");

        FileUtils.copyFile(sourceFull,destinationFull);
    }
}