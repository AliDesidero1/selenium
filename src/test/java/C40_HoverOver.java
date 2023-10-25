import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C40_HoverOver extends TestBase {
    //Go to URL: https://www.amazon.com/
    //Click on “Hello, Sign in Account & Lists” link.
    //Click on Orders page.
    //Verify the page title contains “Amazon”.

    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);

        WebElement helloLink = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement orders = driver.findElement(By.xpath("//span[.='Orders']"));

        //Click on “Hello, Sign in Account & Lists” link.
        //Click on Orders page.
        actions
                .moveToElement(helloLink)
                .click(orders)
                .perform();

        //Verify the page title contains “Amazon”.
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("amazon"));
    }
}