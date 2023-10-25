import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C15_CSSSelector {
    /*
http://the-internet.herokuapp.com/add_remove_elements/
Click on the "Add Element" button 100 times.
Write a function that takes a number, and clicks the "Delete" button.
Given number of times, and then validates that given number of buttons was deleted.
1. Method: createButtons(100)
2. Method: DeleteButtonsAndValidate()

*/
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    //@AfterClass
    //public static void tearDown(){
    //    driver.close();
    //}//Close driver.

    @Test
    public void test(){
        createButtons(100);
        DeleteButtonsAndValidate(25);
    }

    private void DeleteButtonsAndValidate(int i) {
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOncekiSize = deleteButtonList.size();
        System.out.println(silinmedenOncekiSize);

        for (int j =0; j<i; j++) {
            deleteButtonList.get(j).click();
        }

        List<WebElement> geriyekalaDeleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int sildiktensonrakiSize = geriyekalaDeleteButtonList.size();
        System.out.println(sildiktensonrakiSize);

        Assert.assertEquals(silinmedenOncekiSize-i, sildiktensonrakiSize);
    }

    private void createButtons(int i) {
        WebElement addButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int j =0; j<i; j++) {
            addButton.click();
        }
    }
}
 /*
 ****************  CssSelector Arama Yöntemleri    ****************************************

         ---->> Sadece id  için
         By.cssSelector(‘’#logout’’); // id si logout olan

         By.cssSelector(‘’a#logout’’);  // a tag lılar için de id si logout olan

         ----> Sadece Class için
         By.cssSelector(‘’.center’’); // class=‘’center’’

         By.cssSelector(‘’p.center’’);  // p tag lılar için de class i center olan

         ----> Tagname lerle  Arama
         By.cssSelector(‘’input’’); // bütün input taglı olanları seçer.

         By.cssSelector(‘’input[type=‘text’]’’);  //bütün inputlarda type=‘’text’’ olanları seçer

         By.cssSelector(‘’input[type=‘text’][placeholder=‘First Name’]’’) // bütün inputlar içinden type=‘’text’’ ve placeholder=‘’First Name’’ olanı bulur.

         By.cssSelector(‘’[type=‘text’]’’);  //type=‘’text’’ olanları seçer

         By.cssSelector(‘’input.form-control[type=‘text’]’’);  //bütün inputlarda class=‘form-control’ olanlardan type=‘text’ olanlar seçer
         */










