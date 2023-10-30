package HomeWorks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class HMW11_WindowHandle extends TestBase {
    //Go to URL: https://demoqa.com/browser-windows
    //Click on the windows - "WindowButton"
    //Click on all the child windows.
    //Print the text present on all the child windows in the console.
    //Print the heading of the parent window in the console.

    @Test
    public void childWindow () {

        driver.get("https://demoqa.com/browser-windows");

        // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
            }
        }
    }
    @Test
    public void multipleChildWindows  () {

        driver.get("https://demoqa.com/browser-windows");

        // Opening all the child window
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

        // To handle all new opened window
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> ite = s1.iterator();

        // Here we will check if child window has other child windows and when child window
        //is the main window it will come out of loop.
        while (ite.hasNext()) {
            String ChildWindow = ite.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.close();
                System.out.println("Child window closed");
            }
        }
    }

    @Test
    public void switchbackParentWindow   () {

        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("windowButton")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i = s1.iterator();

        while (i.hasNext()) {
            String ChildWindow = i.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }
        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
    }
}

