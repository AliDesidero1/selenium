package CH3CodeChallange.day01;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CC01 {
    /*
     //opening the target website
     //set expected title("OpenAI")
     //using getTitle() to retrieve actual title.
     //click pause button
     //Assertion button text is 'Play video' now.
     //Doing assertion title
     //close driver
     */
    public static void main(String[] args) {
        WebDriver d =new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://openai.com/");
        String expectedTitle="OpenAI";
        String actualTitle=d.getTitle();
        WebElement pauseButton=d.findElement(By.xpath("//button[@aria-label='Pause video']"));
        pauseButton.click();
        System.out.println("Pasue button click yapıldı");
        WebElement playButton =d.findElement(By.xpath("//button[@aria-label='Play video']"));
        Assert.assertEquals("Play video",playButton.getText());
        System.out.println("play  button dogrulandi");
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        System.out.println("Title testi basarili");



    }
}
