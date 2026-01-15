package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public static void main(String[] args) throws IOException {

        // Excel file → Excel Workbook → Sheets → Rows → Cells

        FileInputStream file = new FileInputStream("src/test/java/resources/FETCH_DATA.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int total_rows = sheet.getLastRowNum();
        int total_cells = sheet.getRow(1).getLastCellNum();
        System.out.println("total rows:"+total_rows); //2
        System.out.println("total cells:"+total_cells); //17
        for(int r=0;r<=total_rows;r++)
        {
            XSSFRow current_row = sheet.getRow(r);

            for(int c=0;c<total_cells;c++)
            {
                XSSFCell cell = current_row.getCell(c);
                DataFormatter formatter = new DataFormatter();
                String cellvalue = formatter.formatCellValue(cell);
                System.out.print(cellvalue + "\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
