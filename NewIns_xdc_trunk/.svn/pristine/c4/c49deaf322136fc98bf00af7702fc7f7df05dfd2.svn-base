package com.newins.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelTool {
		// 判断excel版本
		@SuppressWarnings("resource")
		public static Workbook openWorkbook(InputStream in, String filename,
				String fileFileName) throws IOException {
			Workbook wb = null;
			if (fileFileName.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(in);// Excel 2007
			} else {
				wb = (Workbook) new HSSFWorkbook(in);// Excel 2003
			}
			return wb;
		}

		public static StringBuffer getExcelData(String fileName,
				String fileFileName) throws Exception {
			InputStream in = new FileInputStream(fileName); // 创建输入流
			Workbook wb = openWorkbook(in, fileName, fileFileName);// 获取Excel文件对象
			StringBuffer sb = new StringBuffer();
			String queNum = "";
			Sheet sheetAt0 = null;
			//获取 调查问卷题目数量
			try {
				sheetAt0 = wb.getSheetAt(0);
				Row row2 = sheetAt0.getRow(2);
				Cell cell2 = row2.getCell(1);
				queNum = cell2.getNumericCellValue() + "";
				queNum = queNum.substring(0, queNum.length()-2);
//				System.out.println("====================>>调查问卷题目数量："+queNum);
			} catch (Exception e) {
				e.printStackTrace();
//				System.out.println("问卷描述输入内容有误,请重新输入!");
			}
			// 获取 问卷描述信息
			for(int x=0;x<22;x++){
				Row row0 = sheetAt0.getRow(x);
				Cell cell = row0.getCell(1);
				String cellValue = "";
				if (null != cell) {
					// 以下是判断数据的类型
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						cellValue = cell.getNumericCellValue() + "";
						cellValue = cellValue.substring(0, cellValue.length()-2);
						break;
					case HSSFCell.CELL_TYPE_STRING: // 字符串
						cellValue = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = cell.getBooleanCellValue() + "";
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						cellValue = cell.getCellFormula() + "";
						break;
					case HSSFCell.CELL_TYPE_BLANK: // 空值
						cellValue = "";
						break;
					case HSSFCell.CELL_TYPE_ERROR: // 故障
						cellValue = "非法字符";
						break;
					default:
						cellValue = "未知类型";
						break;
					}
					sb.append(cellValue+"!");
				}
			}
			sb.append(";");
			for(int y=1;y<Integer.valueOf(queNum)+1;y++){
				Sheet sheet = wb.getSheetAt(y);// 获取文件的指定工作表m 默认的第一个
				Row row = null;
				Cell cell = null;
				int totalRows = sheet.getPhysicalNumberOfRows(); // 总行数
				int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();// 总列数

				for (int r = 0; r < totalRows; r++) {
					row = sheet.getRow(r);
					for (int c = 1; c < totalCells; c = c+2) {
						if(row!=null){
							cell = row.getCell(c);
							String cellValue = "";
							if (null != cell) {
								// 以下是判断数据的类型
								switch (cell.getCellType()) {
								case HSSFCell.CELL_TYPE_NUMERIC: // 数字
									cellValue = cell.getNumericCellValue() + "";
									cellValue = cellValue.substring(0, cellValue.length()-2);
									break;
								case HSSFCell.CELL_TYPE_STRING: // 字符串
									cellValue = cell.getStringCellValue();
									break;
								case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
									cellValue = cell.getBooleanCellValue() + "";
									break;
								case HSSFCell.CELL_TYPE_FORMULA: // 公式
									cellValue = cell.getCellFormula() + "";
									break;
								case HSSFCell.CELL_TYPE_BLANK: // 空值
									cellValue = "";
									break;
								case HSSFCell.CELL_TYPE_ERROR: // 故障
									cellValue = "非法字符";
									break;
								default:
									cellValue = "未知类型";
									break;
								}
								sb.append(cellValue+"!");
							}
						}
					}
				}
				sb.append(";");
			}
			
//			System.out.println(sb);
			// 返回值集合
			return sb;
		}

		public static void main(String[] args) throws Exception {
			String fileName = "G:/workspace01/NewIns/WebRoot/调查问卷导入模板.xlsx";
			ExcelTool upload = new ExcelTool();
			upload.getExcelData(fileName,".xlsx");
		}

}
