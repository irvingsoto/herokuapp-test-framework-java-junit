package util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.collections4.map.LinkedMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
	
	public static Map<String, String> importDataTable(String dir, String excelname, String sheetname,String findContent) {
		
		String excelpath = System.getProperty("user.dir") + File.separator + dir + File.separator + excelname;

		@SuppressWarnings("unchecked")
		Map<String, String> mapdata = new LinkedMap();
		mapdata = getSpecifySheet(excelpath, sheetname, findContent);

		//System.out.println("Imported Map data:" + mapdata);
		
		return mapdata;
	}

	public static List<Map<String, String>> importDataTable(String dir, String excelname, String sheetname) {
		String excelpath = System.getProperty("user.dir") + File.separator + dir + File.separator + excelname;

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list = getSpecifySheet(excelpath, sheetname);

		//System.out.println("Imported List data:" + list);
		return list;
	}

	public static Map<String, String> getSpecifySheet(String excelpath, String sheetname, String caseName) {

		List<String> header = null;
		Map<String, String> rowmap = new HashMap<String, String>();

		boolean findrow = false;
		int rownumber = 0;

		try {
				Workbook workbook = Workbook.getWorkbook(new File(excelpath));
				Sheet sheet = workbook.getSheet(sheetname);
				int rows = sheet.getRows();
				int columns = sheet.getColumns();
				//System.out.print(rows);
				header = new ArrayList<String>();
				
				for (int columnindex = 0; columnindex < columns; columnindex++) {
					String headerelement = sheet.getCell(columnindex, 0).getContents().trim();
					header.add(columnindex, headerelement);
				}
				
			//System.out.println("File Columns:" + header);
			
			for (int rowindex = 1; rowindex < rows; rowindex++) {
				
				String cellcontent = sheet.getCell(0, rowindex).getContents().toLowerCase().trim();
				
				if (cellcontent.equalsIgnoreCase(caseName)) {
					findrow = true;
					rownumber = rowindex;
					break;
				} else {
					findrow = false;
				}
			}

			if (findrow) {
				for (int columnindex = 0; columnindex < columns; columnindex++) {
					String findcontent = sheet.getCell(columnindex, rownumber).getContents().trim();
					String mapheader = header.get(columnindex);
					rowmap.put(mapheader, findcontent);
				}
			}
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rowmap;
	}

	public static List<Map<String, String>> getSpecifySheet(String excelpath, String sheetname) {

		List<String> header = null;
		Map<String, String> rowmap = new HashMap<String, String>();
		List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();

		try {
			Workbook workbook = Workbook.getWorkbook(new File(excelpath));
			Sheet sheet = workbook.getSheet(sheetname);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			header = new ArrayList<String>();
			for (int columnindex = 0; columnindex < columns; columnindex++) {
				String headerelement = sheet.getCell(columnindex, 0).getContents().trim();
				header.add(columnindex, headerelement);
			}
			
			//System.out.println("File Columns:" + header);
			
			for (int rowindex = 1; rowindex < rows; rowindex++) {
				for (int columnindex = 0; columnindex < columns; columnindex++) {
					String findcontent = sheet.getCell(columnindex, rowindex).getContents().trim();
					String mapheader = header.get(columnindex);
					rowmap.put(mapheader, findcontent);
				}
				
				rowList.add(rowmap);
			}
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rowList;
	}
}