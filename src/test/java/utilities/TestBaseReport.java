package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBaseReport {
    protected WebDriver driver;
    protected Actions actions;

    protected static ExtentReports extentReports; // raporlama islemini gerceklestirir

    protected static ExtentSparkReporter extentHtmlReporter; // raporu HTML olarak duzenler

    protected static ExtentTest extentTest; // testimizin pass veya fail oldugunu saklayan objemiz.
    // Ekran goruntuleri icin de kullanilir

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);

        //Extent report objelerimizi de olusturuyoruz
        extentReports = new ExtentReports();

        // Kaydedecegimiz dosya icin tarih stringi olusturuldu
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
                + "reports" + File.separator + "testReport_" + currentDate + ".html";


        System.out.println("Rapor Dosya Yolu: " + filePath);


        // HTML raporu olusturacak obje dosya yoluyla initialize edildi
        extentHtmlReporter = new ExtentSparkReporter(filePath);

        // Raporlama yapan extentreport objemize HTML reporter baglandi
        extentReports.attachReporter(extentHtmlReporter);

        // Rapor ile alakali ekstra opsiyonel bilgiler verildi
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Tester CW");

        // HTML raporunda goruntulemek istedigimiz konfigurasyonlar yapildi
        extentHtmlReporter.config().setDocumentTitle("jUnit_Report");
        extentHtmlReporter.config().setReportName("Test run report");

    }

    @After
    public void teardown() {
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        extentReports.flush();//arabellegi temizler
    }
}