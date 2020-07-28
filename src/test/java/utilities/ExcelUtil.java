package utilities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import pages.AboutUsPage;
import pages.LandingPage;
import steps.AboutUsPageSteps;

import java.io.*;
import java.util.List;

public class ExcelUtil {

    public String filePath = null;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelUtil() {
        BaseUtil.logger = LogManager.getLogger(ExcelUtil.class.getName());
    }

    public boolean createExcelFile() {
        try {
            filePath = BaseUtil.base_directory + BaseUtil.configProperties.getProperty("excel.file.path");
            BaseUtil.logger.log(Level.INFO, "Creating excel file in:" + filePath);
            workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            BaseUtil.logger.log(Level.INFO, "Created excel file in:" + filePath);
        } catch (Exception e) {
            BaseUtil.logger.log(Level.ERROR, e.getStackTrace());
            return false;
        }
        return true;
    }

    // returns true if sheet is created successfully else false
    public boolean addSheet(String sheetname) {
        try {
            BaseUtil.logger.log(Level.INFO, "Creating sheet:" + sheetname + " in file:" + filePath);
            workbook.createSheet(sheetname);
            fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            BaseUtil.logger.log(Level.INFO, "Creating sheet:" + sheetname + " in file:" + filePath);
        } catch (Exception e) {
            BaseUtil.logger.log(Level.ERROR, e.getStackTrace());
            return false;
        }
        return true;
    }

    public boolean addRowsAndColumns(String filePath, String sheetName, int rowIndex, int columnIndex, List<String> cellValues) {
        try {
            BaseUtil.logger.log(Level.INFO, "Updating excel file in:" + filePath);
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            List<String> values = cellValues;
            int count = 0;
            for (int rows = 0; rows < rowIndex; rows++) {
                for (int column = 0; column < columnIndex; column++) {
                    {
                        row = sheet.getRow(rows);
                        if (row == null)
                        {
                            row = sheet.createRow(rows);
                        }

                        if (row.getLastCellNum() == -1)
                        {
                            cell = row.createCell(column);
                        }
                        else
                        {
                            cell = row.createCell(column);
                        }
                        cell.setCellValue(values.get(count));
                        sheet.autoSizeColumn(column);
                        count++;
                    }
                }
            }

            // Write the output to file
            fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();

            // Closing workbook
            workbook.close();
            BaseUtil.logger.log(Level.INFO, "Updated excel file in:" + filePath);
        } catch (Exception e) {
            BaseUtil.logger.log(Level.ERROR, e.getStackTrace());
            return false;
        }
        return true;
    }
}
