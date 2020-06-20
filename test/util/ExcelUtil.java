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

	public static Map<String, String> getSpecifySheet(String excelpath, String sheetname, String caseName) {

		List<String> header;
		Map<String, String> rowmap = new HashMap<String, String>();

		boolean findrow = false;
		int rownumber = 0;

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

}