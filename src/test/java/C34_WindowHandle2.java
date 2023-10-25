import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C34_WindowHandle2 extends TestBase {
    // 1- browser ac
    // 2- yeni sekme olustur
    // 3- yeni pencere olustur
    // 4- 2. sekmede https://www.linkedin.com/ ac
    // 5- son pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
    // 6- Ilk sekmede https://www.amazon.com/ ac

    @Test
    public void test1() {
        // 2- yeni sekme olustur
        driver.switchTo().newWindow(WindowType.TAB);
        String windowHandleTAB = driver.getWindowHandle();

        // 3- yeni pencere olustur
        driver.switchTo().newWindow(WindowType.WINDOW);
        String windowHandleWINDOW = driver.getWindowHandle();

        // 4- 2. sekmede https://www.linkedin.com/ ac
        driver.switchTo().window(windowHandleTAB);
        driver.get("https://www.linkedin.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle()); // ispat için ..

        // 5- son pencerede https://opensource-demo.orangehrmlive.com/web/index.php/auth/login sitesini ac
        driver.switchTo().window(windowHandleWINDOW);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("driver.getTitle() = " + driver.getTitle()); // ispat için ..

        // 6- Ilk sekmede https://www.amazon.com/ ac
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.get("https://www.amazon.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle()); // ispat için ..





    }
}
