package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static FileInputStream fis;
    private static Workbook workbook;

    public static List<Map<String, String>> getTestData() {
    	String sheetName="Sheet1";
        List<Map<String, String>> dataList = new ArrayList<>();
        
        String filePath="./src/test/resources/testdata.xlsx";
        try {
        	fis = new FileInputStream(filePath);
        	workbook = new XSSFWorkbook(fis);
             

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new RuntimeException("Sheet not found: " + sheetName);

            Row headerRow = sheet.getRow(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = headerRow.getLastCellNum();

            for (int i = 1; i < rowCount; i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;

                Map<String, String> dataMap = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    Cell headerCell = headerRow.getCell(j);
                    Cell dataCell = currentRow.getCell(j);

                    String key = headerCell.getStringCellValue().trim();
                    String value = "";

                    if (dataCell != null) {
                        dataCell.setCellType(CellType.STRING);
                        value = dataCell.getStringCellValue().trim();
                    }

                    dataMap.put(key, value);
                }
                dataList.add(dataMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading Excel file: " + e.getMessage());
        }

        return dataList;
    }
    
    public static void close() {
        try {
            if (workbook != null) workbook.close();
            if (fis != null) fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

