import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C29_Iframe {
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() throws InterruptedException {
        //WebElement content = driver.findElement(By.tagName("p"));

        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        //  xpath : //h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']  , //h3  ,  tagName : h3
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Editor"));

        //Locate the text box
        //textBox webelemetine erismek icin iframe e switch yapmamiz gerekir, aksi takdirde NoSuchElementExcepion aliriz..
        //iframe gecis
        //index ile :starts at 0
        //    driver.switchTo().frame(0);
        //id or name
        //      driver.switchTo().frame("mce_0_ifr");
        //webElement ile
        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.id("tinymce"));

        //Delete the text in the text box
        //textBox.clear();
        textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        Thread.sleep(2000);

        //Type “Hi everyone”
        textBox.sendKeys("Hi everyone");

        //tekrar iframe disinda islem yapmak istersek
        //driver.switchTo().parentFrame(); //1 ust seviyeye cikartir
        driver.switchTo().defaultContent();

        //Verify the text Elemental Selenium text is displayed on the page.
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

    }
}