package HomeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HMW14_KeyboardActions extends TestBase {

    // https://www.google.com/ u ac
    // Arama kismina  keyboard Actionlarla "Scroll Methodlar"  yaz

    @Test
    public void test() {

        driver.get("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Scroll Methodlar"+ Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.
                moveToElement(search).
                click().
                keyDown(Keys.SHIFT).sendKeys("S").keyUp(Keys.SHIFT).
                sendKeys("croll").sendKeys(Keys.SPACE).
                keyDown(Keys.SHIFT).sendKeys("M").keyUp(Keys.SHIFT).
                sendKeys("ethodlar").
                perform();
    }
}
