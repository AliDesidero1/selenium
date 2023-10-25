import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C36_Actions extends TestBase {
    /*
Mouse Actions
click(): Geçerli konumu tıklamak için kullanılır.
doubleClick(): Fare konumuna çift tıklama gerçekleştirmek için kullanılır.
clickAndHold(): Fare tıklamasını serbest bırakmadan gerçekleştirmek için kullanılır.
contextClick(): Geçerli fare konumuna sağ fare tıklaması gerçekleştirmek için kullanılır.
moveToElement (WebElement target): Fare işaretçisini hedef konumun merkezine taşımak için kullanılır.
dragAndDrop(WebElement source, WebElement target): Öğeyi kaynaktan sürüklemek ve hedef konuma bırakmak için kullanılır.
dragAndDropBy(source, xOffset, yOffset): Bu yöntem, kaynak öğeyi tıklar ve tutar ve belirli bir ofset kadar hareket eder, ardından fareyi serbest bırakır. Ofsetler x & y ile tanımlanır.(X = Yatay Kaydır, Y= Dikey Kaydır)
release(): Geçerli konumdaki sol fare düğmesini serbest bırakmak için kullanılır.
perform(): Bir eylemi yürütür. Bu, bir eylemi gerçekleştirmek için sonunda kullanılmalıdır.
perform() KULLANMAYI UNUTMAYIN!
*/
    //Go to URL: https://demoqa.com/buttons
    //Run the buttons on the page using the Actions Class.
    //Verify the texts that appear after the buttons are operated.

    @Test
    public void test(){
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = driver.findElement(By.xpath("(//*[.='Click Me'])[2]"));

        Actions actions = new Actions(driver);// driver üzerinden aksiyonları çalıştırmak için değişken tanımladık

        //actions.doubleClick(doubleClickBtn).perform();
        //actions.contextClick(rightClickBtn).perform();
        //actions.click(clickMe).perform();

        //asagidaki sekilde kullanim daha best practice dir..
        //actions objesindeki methodlar zincirlenebilir..
        actions
                .doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMe)
                .perform();

        //Amele yöntem:
        // actions.moveToElement(doubleClickButton).pause(Duration.ofSeconds(1)).doubleClick().build().perform(); bu sekilde de olur(1 sn durarak)

        //actions objesi ile biz sag click, double click, element uzerine gelme, scroll actionlar gerceklestirebilirz..
        // ancak bu methodlar cagirildiktan sonra perform() cagrilmadigi suree bu operasyonlar calismaz

        //Verify the texts that appear after the buttons are operated.
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());
    }
}