package factory;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelPI {

    public static void main(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\data\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0);
        int colNum = row.getLastCellNum();
        System.out.println("Total Number of Columns in the excel is : "+colNum);
        int rowNum = sheet.getLastRowNum()+1;
        System.out.println("Total Number of Rows in the excel is : "+rowNum);

        for(int i=1;i<rowNum;i++)
        {
            row=sheet.getRow(i);
            for(int j=0;j<colNum;j++)
            {
                System.out.print(sheet.getRow(0).getCell(j).getStringCellValue() +":"+
                        sheet.getRow(i).getCell(j).toString());
            }
            System.out.println();


        }
    }
}
