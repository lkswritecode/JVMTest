package exceltext;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName ImportExcel 导入Excel数据
 * @Author 一个经常熬夜的程序员
 * @CreateDate 2020/7/15 17:08
 * @Version 1.0
 **/
public class ImportExcel {

    public static void main(String[] args) throws IOException {
        ImportExcel importExcel = new ImportExcel();
        importExcel.Excel2007();
    }

    /**
     * xls，使用HSSFWorkbook
     * xls为2003的后缀
     * @throws IOException
     */
    public void Excel2003() throws IOException {
        //获取Excel文件
        POIFSFileSystem fileSystem   = new POIFSFileSystem(new FileInputStream("C:/Users/10913/Desktop/test.xls"));
        //获取工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        //获取页
        HSSFSheet sheet = workbook.getSheet("sheet1");
        //获取行
        HSSFRow row = sheet.getRow(1);
        //获取单元格
        HSSFCell cell = row.getCell(1);
        System.out.println(cell);
    }

    /**
     * xlsx，使用XSSFWorkbook
     * xlsx为2007以后使用的后缀
     * @throws IOException
     */
    public void Excel2007() throws IOException {
        //获取Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook("C:/Users/10913/Desktop/test.xlsx");
        //获取页
        XSSFSheet sheet = workbook.getSheet("sheet1");
        //获取行
        XSSFRow row = sheet.getRow(0);
        //获取格子
        XSSFCell cell = row.getCell(0);
        System.out.println(cell);
    }
}
