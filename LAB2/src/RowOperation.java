import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class RowOperation {
	//ÅÐ¶Ï¿ÕÐÐ
	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			
			Cell cell = row.getCell(c);
			
			if (cell != null && cell.getCellType() != CellType.BLANK)
				return false;
			}
			return true;
	}
	
}
