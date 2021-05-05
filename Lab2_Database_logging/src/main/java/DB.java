import java.util.HashMap;

public class DB {
	private HashMap<String, DBTable> tables;

	public DB() {
		tables = new HashMap<String, DBTable>();
	}
	// This method is not a transaction type; it is public to enable testing
	public DBTable getTable(String name) {
		if (tables.containsKey(name)) {
			return tables.get(name);
		}
		else return null;
	}
	// the following methods are transactions
	public void createTable(String name, int columns) {
		tables.put(name, new DBTable(columns));
	}

	public void insert(String tableName, String[] row) {
		DBTable tab = getTable(tableName);
		try {
			tab.addRow(row);
		} catch (DBTable.BadData e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	// Returns a table that contains all the rows from tab that have column col equal to selector
	public DBTable select(String tabName, int col, String selector) {
		DBTable tab = getTable(tabName);
		DBTable retvalTable = new DBTable(tab.nColumns);
		try {
			for (int i = 0; i < tab.numRows(); ++i) {
				if (tab.get(i, col).equals(selector)) {
					retvalTable.addRow(tab.getRow(i));
				}
			}
		} catch (DBTable.BadData e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return retvalTable;
	}
	// Relational join
	public DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col) {
		DBTable tab1 = getTable(tab1Name);
		DBTable tab2 = getTable(tab2Name);
		DBTable retval = new DBTable(tab1.nColumns + tab2.nColumns);
		try {
			for (int i = 0; i < tab1.numRows(); ++i) {
				for (int j = 0; j < tab2.numRows(); ++j) {
					if (tab1.get(i, tab1Col).equals(tab2.get(j, tab2Col))) {
						retval.addRow(tab1.getRow(i), tab2.getRow(j));
					}
				}
			}
		} catch (DBTable.BadData e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return retval;
	}
}
