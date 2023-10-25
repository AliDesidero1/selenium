import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C21_DropDown1 {
    //Dropdown : acilir pencere
    //Dropdownlar ozel etkilesimler gerektirdiginden dolayi Selenium bize dropdownlar icin ayri bir class olusturmustur..
    //Class-> Select

        /*Dropdownlar ile calisirken
            * <select> elementi locate edilir  : //select[@id='oldSelectMenu']
            *  select elementi kullanilarak select objesi olusturulur
                Select select = new Select(webElement)
            *  select objesi araciligiyla metodlar kullanilir..
                1-selectByIndex() : option elementinin indexi
                2-selectByValue() : option elementinin value attribute u
                3-selectByVisibleText(): option elementinin gorunur yazisi
            //Select elementlerinde info amaciyla kullanilan methodlar
             select.getAllSelectedOptions(); -> multi selectte secili tum degerleri bize return eden methoddur.
             select.getFirstSelectedOption(); -> Secili ilk option elementini bize getirir.
             select.getOptions(); -> select elementinin tum optionlarini liste halinde return eder
             select.isMultiple(); -> select elementinin multiple secime uygun olup olmadigni bize boolean olarak return eder.

            // 1- deselectByIndex() -> option elementini index ile  kaldirir
            // 2- deselectByValue() -> option elemenini value attribute ile kaldirir
            // 3- deselectByVisibleText() -> option elementini gorunur yazisi (contenti) ile kaldirir
            // 4- deselectAll() -> Butun secimleri kaldirir.
         */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void test() {
        //<select> elementini locate et
        WebElement selectOne = driver.findElement(By.id("selectOne"));

        //select elementini kullanrak select objesi olustur
        Select select = new Select(selectOne);

        //Select classi kullanilirken parametre olarak verilen elementimiz kesinlikle <select> olmalidir..
        //<select> olmadiginda UnexpectedTagNameException firlatilir..

        driver.close();
    }
}