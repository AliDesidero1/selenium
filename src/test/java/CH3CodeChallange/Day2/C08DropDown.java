package CH3CodeChallange.Day2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C08DropDown {
    /*
1) Open the browser
2) Enter the URL “https://bonigarcia.dev/selenium-webdriver-java/web-form.html”
3)Choose "Three"
4)Verify option Label
   */
    static WebDriver driver;//class seviyesinde tanımlamalıyız
    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement selectMenu=driver.findElement(By.name("my-select"));
        Select select = new Select(selectMenu);
        String optonLabel="Three";
        select.selectByVisibleText(optonLabel);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),optonLabel);
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
