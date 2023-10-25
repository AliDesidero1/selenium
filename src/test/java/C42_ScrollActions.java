import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C42_ScrollActions extends TestBase {

    //Go to URL: https://www.amazon.com/
//By using PAGE_UP, PAGE_DOWN, ARROW_UP, ARROW_DOWN
//use actions scroll the page
//scroll down
//scroll up.
    @Test
    public void scrollPageUpDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://www.amazon.com/");

        actions.sendKeys(Keys.PAGE_DOWN) .perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN) .perform();
        Thread.sleep(1000);// toplamda 2 satir aşagi yapmasini sagladik sitede. .


        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();// 2 satir yukari cıkmasini saglaadik ..
    }

    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://www.amazon.com/");

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();




    }


}
