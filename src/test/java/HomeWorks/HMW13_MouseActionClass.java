package HomeWorks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HMW13_MouseActionClass extends TestBase {
    /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.xpath("//a[contains(text(),'BANK')]"));

        WebElement sales = driver.findElement(By.xpath("//a[contains(text(),'SALES')]"));

        WebElement num5000 = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[2]"));

        WebElement num5000second = driver.findElement(By.xpath("(//a[contains(text(),'5000')])[4]"));

        WebElement bankAccount = driver.findElement(By.xpath("//ol[@id='bank']"));

        WebElement bankAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));

        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));

        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(bank, bankAccount).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(sales, creditAccount).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(num5000, bankAmount).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(num5000second, creditAmount).perform();

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        // WebElement perfectTxt = driver.findElement(By.linkText("\"Perfect!\""));
        WebElement perfectTxt = driver.findElement(By.xpath("//a[.='Perfect!']"));
        Assert.assertTrue(perfectTxt.isDisplayed());
    }
}