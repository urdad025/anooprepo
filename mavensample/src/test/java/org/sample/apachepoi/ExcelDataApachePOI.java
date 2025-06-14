package org.sample.apachepoi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataApachePOI {

	public ArrayList<String> getData(String testCaseName) throws IOException {

		/*
		 * Task is to: Scan the first row and identify the TestCase column. Once
		 * TestCase column is identified, scan entire TestCases column to identify
		 * Purchase test case row. Once Purchase row identified, pull all the data of
		 * that row.
		 */

		ArrayList<String> a = new ArrayList<>();

		FileInputStream fis = new FileInputStream("/Users/dou6339/Documents/ExcelDataSelenium/ApachePOI.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Main Data")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				// Scan the first row and identify the TestCase column.

				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();// row is collecton of cells

				int k = 0;
				int columnCount = 0;

				while (cells.hasNext()) {
					Cell value = cells.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						columnCount = k;

					}
					k++;
				}

				System.out.println("Column Count: " + columnCount);

				// TestCase column is identified, scan entire TestCases column to identify
				// Purchase test case row.

				while (rows.hasNext()) {
					Row nextRow = rows.next();

					if (nextRow.getCell(columnCount).getStringCellValue().equalsIgnoreCase(testCaseName)) { // Identified...
						// Once Purchase row identified, pull all the data of that row.
						Iterator<Cell> nextRowCells = nextRow.cellIterator();

						while (nextRowCells.hasNext()) {

							Cell cellObj = nextRowCells.next();

							switch (cellObj.getCellType()) {
							case STRING:
								a.add(cellObj.getStringCellValue());
								break;
							case NUMERIC:
								a.add(NumberToTextConverter.toText(cellObj.getNumericCellValue())); // handles int, double, etc.
								break;
							case BOOLEAN:
								a.add(String.valueOf(cellObj.getBooleanCellValue()));
								break;
							case FORMULA:
								a.add(cellObj.getCellFormula());
								break;
							case BLANK:
								a.add(""); // or skip/add null
								break;
							default:
								a.add("Unsupported cell type");
								break;
								
								
							}
						}
					}
				}
			}
		}
		return a;
	}
}
