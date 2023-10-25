import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C38_DragAndDropByHorizontal extends TestBase {

    //Go to URL: https://rangeslider.js.org/
    //Shift 100 units to the right and 100 units to the left on the horizontal axis.

    @Test
    public void test(){
        driver.get("https://rangeslider.js.org/");

        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.cssSelector("div.rangeslider__handle"));

        actions.clickAndHold(slider)
                .moveByOffset(100, 0)  // X ekseninde 100 birim sağa
                .release()
                .perform();
        System.out.println("slider.getText() = " + slider.getText());

        actions.clickAndHold(slider)
                .moveByOffset(-100, 0)  // X ekseninde 100 birim sola
                .release()
                .perform();
        System.out.println("slider.getText() = " + slider.getText());


    }

}
