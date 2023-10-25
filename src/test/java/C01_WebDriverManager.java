
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C01_WebDriverManager {
    /*
Java Tabanlı Projeye bağımlılığı yönetmenin bir yoludur.
Projenin kalbidir..
• Maven, büyük projeler üzerinde çalışırken POM (Project Object Model) ile proje oluştururken kullanılabilir.
• Birden çok IDE (IntelliJ, Eclipse, vs.) ile çalışır.
• Maven bir Java derleme ve yönetim aracıdır.
• Maven ile tüm otomasyon süreci sürecini yönetmek için maven projesi oluşturabilirsiniz.
• Maven, pom.xml dosyası ile dependency’leri yönetmemize yardımcı oluyor.
• Maven, Java uygulamalarını derlememize, çalıştırmamıza ve dağıtmamıza yardımcı oluyor.
• Ant ve Gradle gibi başka araçlar da var ancak Maven en popüler olanıdır.
*/
    /*
    • Set Path.
    • Create chrome driver.
    • Maximize the window.
    • Open google home page https://www.google.com/
    • Verify that title is Google.
     */
    public static void main(String[] args) {
        // System.setProperty("....") buna ihityac yok
        // Artik pom.xml de kullancagimiz kaynak kodlarimiz var, ordan kullanacagiz..
        // Bunun yerine WebDriverManager kullanacagiz

        //chromedriveri cagirma ve kurma

        //WebDriverManager.chromedriver().setup(); NO NEED !!!
        /*
        If you are using selenium v4.6.0 and above, then you don't need WebDriverManager anymore.
        Selenium has an inbuilt tool now to handle drivers. Remove the above line from your code, you don't need it.
         */

        //Create chrome driver.
        WebDriver driver = new ChromeDriver();

        //Maximize the window.
        driver.manage().window().maximize();

        //Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        //Verify that title is Google.
        System.out.println(driver.getTitle().equals("Google")? "Title is Google" : "Title is not Google");

        driver.close();
    }
}


