import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class C51_ApachePoiGetData {
    String sheetName;
    int sheetIndex;
    int rowIndex;
    int columnIndex;

    public static Object getData(String sheetName, int rowIndex, int columnIndex) throws IOException {
        String istenenData = "";
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\excelfile.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        istenenData = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).toString();

        return istenenData;
    }

}

