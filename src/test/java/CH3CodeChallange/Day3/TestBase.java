package CH3CodeChallange.Day3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class TestBase {
    protected WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
//        driver.quit();
    }
    public void clickElement(By element){
        WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
        w.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(driver,driver.findElement(element));
        driver.findElement(element).click();
    }
    public void setText(By element,String text){
        driver.findElement(element).sendKeys(text);
    }
    public void switchToWindow(int tab){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tab));
    }
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
//        pauseMethod(1);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style');", element);
    }
}

