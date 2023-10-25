import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C22_DropDown2 {
    /*
  Launch the browser.
  Open "https://demoqa.com/select-menu".
  Select the Old Style Select Menu using the element id.
  Print all the options of the dropdown.
  Select 'Purple' using the index.
  After that, select 'Magenta' using visible text.
  Select an option using value.
  Close the browser.
*/
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void test() throws InterruptedException {
        WebElement dropDown1 = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropDown1);

        List<WebElement> optionsList = select.getOptions();
        System.out.println("optionsList = " + optionsList);//referansları getirir.

        for (WebElement each : optionsList){
            System.out.println("each.getText() = " + each.getText());
        }

        //WebElement purple = driver.findElement(By.xpath("//*[.='Purple']"));
        //dropDown1.click();
        //Thread.sleep(2000);
        //purple.click();

        //Select 'Purple' using the index.
        select.selectByIndex(4);

        Thread.sleep(2000);
        //After that, select 'Magenta' using visible text.
        select.selectByVisibleText("Magenta");

        Thread.sleep(2000);
        //Select an option using value.
        select.selectByValue("8");

        driver.close();
    }
}

