import java.io.*;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadFile {
	public static void main(String[] args) {
		try {
			String excelPath = "D:\\temp\\book.xls";
			FileInputStream fileInputStream = new FileInputStream(new File(
					excelPath));

			// Create Workbook instance holding .xls file
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

			// Get the first work sheet
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				// Get Each Row
				Row row = rowIterator.next();
				// Get Each Cell
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					System.out.print(cell.toString() + "\t");
				}
				System.out.println("");
			}
			workbook.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}
}