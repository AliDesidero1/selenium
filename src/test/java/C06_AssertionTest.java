import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_AssertionTest {
    /*
       Go to Amazon homepage
       Do the following tasks by creating 3 different test methods.
       1- Test if the URL contains Amazon.
       2- Test if the title does not contain Facebook.
       3- Test that the Amazon logo appears in the upper left corner.
        */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1(){
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }

    @Test
    public void test2(){
        Assert.assertFalse(driver.getTitle().contains("Facebook"));
    }

    @Test
    public void test3(){
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
    }
}