import java.util.ArrayList;


public class DBTable {
	private ArrayList<String[]> data;
	private int firstFree = 0;
	int nColumns;
	public DBTable(int nColumns) {
		data = new ArrayList<String[]>();
		this.nColumns = nColumns;
	}
	// Will throw an exception if either row or col is too big or negative
	public String get(int row, int col) {
		return data.get(row)[col];
	}
	public class BadData extends Exception {
		private String message;

		public BadData(String message) {
			super();
			this.message = message;
		}
		public String getMessage() { return message; }
	}
	public void addRow(String[] toAdd) throws BadData {
		if (toAdd.length != nColumns) {
			throw new BadData("Expected " + nColumns + " columns but got a row with " + toAdd.length + " columns.");
		}
		data.add(toAdd);
	}
	public void addRow(String[] toAddPrefix, String[] toAddSuffix) throws BadData {
		if (toAddPrefix.length + toAddSuffix.length != nColumns) {
			throw new BadData("Expected " + nColumns + " columns but got a row with " + toAddPrefix.length + "+" + toAddSuffix.length + " columns.");			
		}
		String row[] = new String[toAddPrefix.length + toAddSuffix.length];
		for (int i = 0; i < toAddPrefix.length; ++i) {
			row[i] = toAddPrefix[i];
		}
		for (int i = 0; i < toAddSuffix.length; ++i) {
			row[i+toAddPrefix.length] = toAddSuffix[i];
		}
		addRow(row);
	}
	public int numRows() {
		return data.size();
	}
	public String[] getRow(int row) {
		return data.get(row);
	}
}
