package CH3CodeChallange.Day3;

import org.junit.Test;
import org.openqa.selenium.By;

public class C013WindowHandle extends TestBase{
    // Step 1: Go to the URL https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open


    // Step 3: Switch to the new window that opened
    // Step 4: Switch back to the original window by using the window handle
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        driver.switchTo().frame("iframeResult");

        By TryItButton = By.xpath("//button[text()='Try it']");
        clickElement(TryItButton);

        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
            String newTitle=driver.getTitle();
            System.out.println("newTitle = " + newTitle);
            String newURL = driver.getCurrentUrl();
            System.out.println("newURL = " + newURL);
        }
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println(" Son Title= "+driver.getTitle());
    }

}
