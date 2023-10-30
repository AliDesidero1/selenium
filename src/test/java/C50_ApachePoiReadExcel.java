import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C50_ApachePoiReadExcel {
    //Workbook  Excel dosyamız.
    //Sheet  Açık excel sekmesi (Sheet1, Sheet2, etc.)
    //Row (Satır)  Java, yalnızca içeride veri varsa satırları sayar.
    //Cells (Hücre)  Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar.

        //workbook(excel)>worksheet(sheet)> row(satir)>cell(hucre) -> hiyerarsi

        // Add the excel file on the resources folder.
        // Open the file.
        // Open the workbook using file input stream.
        // Open the first worksheet.
        // Go to first row.
        // Go to first cell on that first row and print.
        // Go to second cell on that first row and print.
        // Go to 2nd row first cell and assert if the data equal to Russia.
        // Go to 3rd row and print 2nd cell
        // Find the number of used row.
        // Print co   untry, area key value pairs as map object.
        // Verify that you have Türkiye on the list

    @Test
    public void readExcel() throws IOException {
        //okunacak excel dosyamizin pathi
        //C:\...\...\IdeaProjects\CWJUnitProject\src\test\resources\excelfile.xlsx
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";

        // Open the workbook using file input stream.
        FileInputStream fis = new FileInputStream(path);

        Workbook wb = WorkbookFactory.create(fis);

        // Open the first worksheet.
        Sheet sheet1 = wb.getSheet("Sayfa1");
        Sheet sheet2 = wb.getSheetAt(0);

        // Go to first row.
        Row row1 = sheet1.getRow(0);

        // Go to first cell on that first row and print.
        Cell cell = row1.getCell(0);

        System.out.println("cell = " + cell);
        System.out.println("cell = " + cell.toString());

        // Go to second cell on that first row and print.
        Cell r1c2 = row1.getCell(1);
        System.out.println("r1c2 = " + r1c2);

        // Go to 2nd row first cell and assert if the data equal to Russia.
        Assert.assertEquals("Rusya", sheet1.getRow(1).getCell(0).toString());

        // Go to 3rd row and print 2nd cell
        System.out.println(sheet1.getRow(2).getCell(1).toString());

        // Find the number of used row.
        //***getLastRowNum() index starts at 0 * checks the last row that is used
        //son kullanilan satirin index bilgisini bize verir..
        //son satır öncesindeki boş satırlar sonucu etkilemez.
        System.out.println((sheet1.getLastRowNum() + 1));

        //***getPhysicalNumberOfRows() index starts at 1  * checks the total rows that is used
        //kullanilan toplam satir sayisini bize verir,satirlar 1 den baslar, bos satir sayilmaz
        //yani fiziksel olarak mevcut olan satirlari sayar
        System.out.println(sheet1.getPhysicalNumberOfRows());

        // Print country, area key value pairs as map object.
        //country-area bilgilerini key-value formatinda map gibi yazdiralim
        // excel de 2 sutun oldugu takdirde asagidaki sekilde yapilabilir.
        Map<String, String> country_area = new HashMap<String, String>();
        for(int i = 0; i <=sheet1.getLastRowNum(); i++){
            String country = sheet1.getRow(i).getCell(0).toString();
            String area = sheet1.getRow(i).getCell(1).toString();
            country_area.put(country,area);
        }

        System.out.println(country_area);

        // Verify that you have Türkiye on the list
        Assert.assertTrue(country_area.containsKey("Türkiye"));

        //methodla yapalım
        System.out.println(C51_ApachePoiGetData.getData("Sayfa1", 2, 1));
    }
}
/*
        Cell cell = WorkbookFactory.create(new FileInputStream(path)).getSheetAt(0).getRow(0).getCell(0);
        System.out.println("cellValue: "+WorkbookFactory.create(new FileInputStream(path)).getSheetAt(0).getRow(0).getCell(0));
 */