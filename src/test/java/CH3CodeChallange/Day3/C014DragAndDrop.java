package CH3CodeChallange.Day3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C014DragAndDrop extends TestBase{
    @Test
    public void testDragAndDrop() {
 /*
  web sayfasına gidin: https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html
Sayfadaki "draggable" elementini tanımlayın ve başlangıç konumunu alın.
"draggable" elementini sürükleyerek sağa doğru 100 piksel hareket ettirin, ardından sola, yukarı ve aşağı yönlere sırasıyla 100 piksel hareket ettirin.
sürükle ve bırak işlemi sonrasında, "draggable" elementinin yeni konumunu alın ve başlangıç konumuyla karşılaştırın.
Eğer başlangıç konumuyla aynıysa, bu adım başarılı kabul edilir.


"draggable" elementini "target" elementine sürükleyin.
"draggable" elementinin son konumunu alın ve bu konumun "target" elementiyle aynı olduğunu doğrulayın.
*/
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        WebElement draggable=driver.findElement(By.id("draggable"));
        Point firstLocation=driver.findElement(By.id("draggable")).getLocation();
        Actions actions=new Actions(driver);
        actions.
                dragAndDropBy(draggable,100,0).
                dragAndDropBy(draggable,0,100).
                dragAndDropBy(draggable,-100,0).
                dragAndDropBy(draggable,0,-100).perform();

        Assert.assertEquals(firstLocation,draggable.getLocation());

        WebElement target=driver.findElement(By.id("target"));

        actions.dragAndDrop(draggable,target).perform();

        Assert.assertEquals(target.getLocation(),draggable.getLocation());
    }

    @Test
    public void test02() throws InterruptedException {
        /*
        Coding assignment:
URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html

UC -1 : +ve
Drag all the capitals to the respective country section.ex:
Oslo  to  Norway
Washington to United States

--- move all the capitals back to the capitals left section

UC - 2 Drag all the capitals to the wrong countries
Washington  to  South Korea
--- move all the capitals back to the capitals left section

UC -3 : correct + incorrect combinations
Oslo - Norway
Madrid  to  Sweden
--- move all the capitals back to the capitals left section
        */
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions = new Actions(driver);
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweeden = driver.findElement(By.id("box102"));
        WebElement US = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement korea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
////test case -01
//        actions.dragAndDrop(oslo,norway).
//                dragAndDrop(stockholm,sweeden).
//                dragAndDrop(washington,US).
//                dragAndDrop(copenhagen,denmark)
//                .dragAndDrop(seoul,korea)
//                .dragAndDrop(rome,italy)
//                .dragAndDrop(madrid,spain).perform();
//        Assert.assertEquals("visibility: visible; background-color: rgb(0, 255, 0);", rome.getAttribute("style"));

////test case -02
//        actions.dragAndDrop(oslo,norway).
//                dragAndDrop(stockholm,sweeden).
//                dragAndDrop(washington,korea).
//                dragAndDrop(copenhagen,denmark)
//                .dragAndDrop(seoul,US)
//                .dragAndDrop(rome,italy)
//                .dragAndDrop(madrid,spain).perform();
//        Assert.assertEquals("visibility: visible;",washington.getAttribute("style"));

        actions.dragAndDrop(oslo,sweeden).
                dragAndDrop(stockholm,spain).
                dragAndDrop(washington,denmark).
                dragAndDrop(copenhagen,korea)
                .dragAndDrop(seoul,italy)
                .dragAndDrop(rome,US)
                .dragAndDrop(madrid,norway).perform();
        Assert.assertEquals("visibility: visible;",washington.getAttribute("style"));
        Assert.assertEquals("visibility: visible;",copenhagen.getAttribute("style"));
        Assert.assertEquals("visibility: visible;",seoul.getAttribute("style"));
        Assert.assertEquals("visibility: visible;",rome.getAttribute("style"));
        Assert.assertEquals("visibility: hidden;",madrid.getAttribute("style"));
        Thread.sleep(3000);
    }
}

