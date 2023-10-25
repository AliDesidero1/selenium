import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C39_DragAndDropByVertical extends TestBase {
    // Go to URL: https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html
    // Shift 34 units to the up and 34 units to the down on the vertical axis.

    @Test
    public void dragSliderYaxe(){
        driver.get("https://foundation.zurb.com/sites/docs/v/5.5.3/components/range_slider.html");
        Actions actions = new Actions(driver);

        WebElement slider = driver.findElement(By.xpath("//span[@role='slider']"));

        actions
                .dragAndDropBy(slider,0,-34)
                .perform();

        WebElement output = driver.findElement(By.cssSelector("span#sliderOutput2"));
        System.out.println(output.getText());

        actions
                .dragAndDropBy(slider,0,34)
                .perform();

        System.out.println(output.getText());
    }
}