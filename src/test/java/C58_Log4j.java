import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C58_Log4j extends TestBase {
    //Go to URL: https://healthunify.com/bmicalculator/
    //Entring weight
    //Selecting kilograms
    //Selecting height in feet
    //Selecting height in inchs
    //Clicking on calculate
    //Getting SIUnit value
    //Getting USUnit value
    //Getting UKUnit value
    //Getting overall description
    @Test
    public void test(){
        //loglarimizi configure etmek icin
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(C58_Log4j.class);
        logger.info("Go to URL");
        driver.get("https://healthunify.com/bmicalculator/");
        logger.info("website is opened");
        logger.info("Entring weight");
        WebElement weight = driver.findElement(By.xpath("//input[@name='wg']"));
        weight.sendKeys("84");
        logger.info("Selecting kilograms");
        driver.findElement(By.name("opt1")).sendKeys("kilograms");
        logger.info("Selecting height in feet");
        driver.findElement(By.name("opt2")).sendKeys("5");
        logger.info("Selecting height in inches");
        driver.findElement(By.name("opt3")).sendKeys("6");
        logger.info("Clicking on calculate button");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        //driver.findElement(By.xpath("//input[@name='cc']")).sendKeys(Keys.SPACE); 2.yol
        logger.info("getting SIUnit value");
        String SIUNIT = driver.findElement(By.xpath("//input[@name='si']")).getAttribute("value");
        System.out.println("SIUNIT = " + SIUNIT);
        logger.info("getting USunit value");
        String USUNIT = driver.findElement(By.xpath("//input[@name='us']")).getAttribute("value");
        System.out.println("USUNIT = " + USUNIT);
        logger.info("getting UKunit value");
        String UKUNIT = driver.findElement(By.xpath("//input[@name='uk']")).getAttribute("value");
        System.out.println("UKUNIT = " + UKUNIT);
        logger.info("Getting overall description");
        String desc = driver.findElement(By.xpath("//input[@name='uk']")).getAttribute("value");
        System.out.println("desc = " + desc);
        logger.info("test is ending");
    }
}