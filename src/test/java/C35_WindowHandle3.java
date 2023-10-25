import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class C35_WindowHandle3 extends TestBase {
// 1- browser ac
    // 2- acilan sekmede https://www.amazon.com/ ac
    // 3- yeni sekme olustur
    // 4- acilan sekmede https://www.linkedin.com/ ac
    // 5- yeni pencere olustur
    // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz

    @Test
    public void test1() {
        // 2- acilan sekmede https://www.amazon.com/ ac
        driver.get("https://www.amazon.com/");
        String amazonHandle = driver.getWindowHandle();

        // 3- yeni sekme olustur.
        driver.switchTo().newWindow(WindowType.TAB);

        // 4- acilan sekmede https://www.linkedin.com/ ac
        driver.get("https://www.linkedin.com/");
        String linkedHandle = driver.getWindowHandle();

        // 5- yeni pencere olustur.
        driver.switchTo().newWindow(WindowType.WINDOW);

        // 6- acilan pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String opensourceHandle = driver.getWindowHandle();

        // 7- amazon sekmesine gecerek arama kismina 'Amazon sekmesini buldun' yaz
        driver.switchTo().window(amazonHandle);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Amazon sekmesini buldun");

        // ikinci yol ..

         //window handle ler arasi gecis yapmamiz gerek
        //set objesi olusturmaliyiz..
        Set<String> windowHandles = driver.getWindowHandles();
        //set uzerinde gezecegim bir objesi olmadigindan iterator kullanacagiz.

        Iterator<String> i = windowHandles.iterator();

        while (i.hasNext()) {//i.hasNext() ifadesi , i isimli bir nesnenin bir sonraki elemani olup olmadigini kontrol eder
            String currentHandle = i.next();//i.next() ifadesi , i isimli bir nesnenin bir sonraki elemani bu degiskene atamaktadir.
            driver.switchTo().window(currentHandle);
            System.out.println(driver.getWindowHandle()); //3 farkli WH degeri gormeliyiz

            if(driver.getTitle().toLowerCase().contains("amazon")){
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Amazon sekmesini buldun BRAVO");
                break;
            }
        }
    }
}