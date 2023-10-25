import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C43_JavascriptExecuter extends TestBase {
     /*
JavascriptExecutor js = (JavascriptExecutor)driver;
JavascriptExecutor kullanmak için ilk adım olarak driver’ı JavascriptExecutor interface’sine cast etmektir.
Bu interface sayesinde sayfa kaydırma işlemi ve JavaScript komutları çalıştırılabilir
En yaygın kullanılan methodu, executescript() methodudur.
​
executeScript - ScrollBy () web sayfasını verilen piksel değeri kadar ileri gider.
executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
js.executeScript("window.scrollBy(0,1000));  Dikey olarak 1000 piksel aşağı kaydırır.
​
executeScript - ScrollTo () web sayfasını verilen piksel değerine götürür.
js.executeScript("window.scrollTo(0, 0)");  tarayıcının en üstüne kaydırma işlemi gerçekleştirir.
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");  tarayıcının en altına kaydırma işlemi gerçekleştirir.
js.executeScript("arguments[0].click()", element);-> elemente click yapar
scrollIntoView () web sayfasındaki bir öğenin görünürlüğüne göre kaydırır.
js.executeScript("arguments[0].scrollIntoView();",WebElement);
*/

    //Go to URL: https://api.jquery.com/dblclick/
    //Doubleclick on the blue square at the bottom of the page and then write the changed color.
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://api.jquery.com/dblclick/");

        Actions actions = new Actions(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver; //cast ederek bu ifadeyi elde ettik

        driver.switchTo().frame(0);
        WebElement doubleClickBtn = driver.findElement(By.cssSelector("body>div"));

        jse.executeScript("arguments[0].scrollIntoView();",doubleClickBtn); //hedef webelemente kadar scroll yap
        //JavascriptUtils.scrollIntoViewJS(driver, doubleClickBtn);

        System.out.println(doubleClickBtn.getCssValue("background-color"));

        actions.doubleClick(doubleClickBtn).perform();

        System.out.println(doubleClickBtn.getCssValue("background-color"));

        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='s']"));

        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        searchBox.sendKeys("JavascriptExecutor çogğgğgğ iyi");

        Thread.sleep(3000);
        WebElement book = driver.findElement(By.xpath("(//img[contains(text(),'')])[3]"));

        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);

        book.click();
    }
}