package org.sample.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {

	DataFormatter df = new DataFormatter();

	@Test(dataProvider = "driverTest")
	public void testCaseData(String greet, String comm, String id) {
		System.out.println(greet + " --> " + comm + " --> " + id);
	}

	@DataProvider(name = "driverTest")
	public Object[][] getData() throws IOException {
		// Object[][] data = { { "Hello", "Text", 1 }, { "Bye", "Message", 143 }, {
		// "Solo", "Call", 119 } };
		// return data;

		FileInputStream fis = new FileInputStream("/Users/dou6339/Documents/ExcelDataSelenium/ExcelDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows(); // rowCount = 4
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum(); // rowCount=3

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);
				data[i][j] = df.formatCellValue(cell);

			}

		}
		return data;

	}
}
