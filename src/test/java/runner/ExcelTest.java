package runner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExcelTest {
    public static void main(String[] args) {

  File file=new File("src/test/resources/data/testData.xlsx");
        try {
            FileInputStream input=new FileInputStream(file);
            XSSFWorkbook workbook=new XSSFWorkbook(input);
            XSSFSheet excelSheet=workbook.getSheet("Sheet1");
             String values= excelSheet.getRow(0).getCell(0).toString();
            System.out.println(values);
            System.out.println(excelSheet.getRow(1).getCell(3));
            XSSFRow row=excelSheet.getRow(1);
            XSSFCell cell=row.getCell(2);
            System.out.println(cell);
            // if column is empty
            //using create cell
            XSSFRow row2=excelSheet.getRow(4);
            XSSFCell cell2=row2.createCell(3);
            cell2.setCellType(CellType.STRING);
            cell2.setCellValue("Chicago");
            FileOutputStream fileOutputStream=new FileOutputStream("src/test/resources/data/testData.xlsx");
            workbook.write(fileOutputStream);


        } catch (Exception e) {
            System.out.println("Excel file does not exist");
        }


    }
}
