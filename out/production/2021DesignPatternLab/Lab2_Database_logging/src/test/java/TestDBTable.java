import junit.framework.TestCase;
/*
 * Created on Sep 26, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class TestDBTable extends TestCase {
	public void testAddRow() {
		DBTable tab = new DBTable(3);
		String row[] = {"1A", "1B", "1C"};
			try {
				tab.addRow(row);
				assertEquals("1B", tab.get(0,1));
			} catch (DBTable.BadData e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void testAddRowPrefixSuffix() {
		DBTable tab = new DBTable(3);
		String rowPrefix[] = {"1A", "1B"};
		String rowSuffix[] = {"1C"};
			try {
				tab.addRow(rowPrefix, rowSuffix);
				assertEquals("1B", tab.get(0,1));
			} catch (DBTable.BadData e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
