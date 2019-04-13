package com.company.execl.report;
import com.company.graph.Graph;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class WriterExcel {
	private static String[] columns={"Name","Description" ,"Path tgf file","Path image file"};
	private  static List<DataPdf> excel=new ArrayList<>();
	public WriterExcel(Map<String, Graph> catalog) {
		for (Map.Entry<String, Graph> entry : catalog.entrySet()) {
			if (entry.getValue().getDescription() == null)
				excel.add(new DataPdf(entry.getValue().getName(), " ", entry.getValue().getPathDefinition(), entry.getValue().getPathImage()));
			else
				excel.add(new DataPdf(entry.getValue().getName(), entry.getValue().getDescription(), entry.getValue().getPathDefinition(), entry.getValue().getPathImage()));
		}
	}
	public  void run(){
		Workbook workbook=new XSSFWorkbook();
		CreationHelper creationHelper=workbook.getCreationHelper();
		Sheet sheet=workbook.createSheet("raport");
		Font headerFont=workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());

		CellStyle headerCellStyle=workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		Row headerRow=sheet.createRow(0);
		for(int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		int rowNum = 1;
		for(DataPdf employee: excel) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0)
					.setCellValue(employee.getName());

			row.createCell(1)
					.setCellValue(employee.getDescription());


			row.createCell(2)
					.setCellValue(employee.getPathTgf());

			row.createCell(3)
					.setCellValue(employee.getPathImage());


		}

		for(int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		try {
			FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
