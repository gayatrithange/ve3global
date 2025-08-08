package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] validUsernameAndPassword(String filePath, String sheetName) {
		Object data[][] = null;
		FileInputStream fis = null;
		Workbook book = null;
		try {
			fis = new FileInputStream(filePath);

			book = new XSSFWorkbook(fis);

			Sheet sheet = book.getSheet(sheetName);
			int rownum = sheet.getLastRowNum();
			int cellnum = sheet.getRow(0).getLastCellNum();
			data = new Object[rownum][cellnum];
			for (int i = 1; i <= rownum; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cellnum; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = cell.getStringCellValue();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis.close();
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

}
