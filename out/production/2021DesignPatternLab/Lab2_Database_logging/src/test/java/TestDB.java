import junit.framework.TestCase;
/*
 * Created on Sep 26, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class TestDB extends TestCase {
	public void testCreateTable() {
		DB db = new DB();
		db.createTable("MyTable", 3);
		assertNotNull(db.getTable("MyTable"));
	}
	
	public void testInsert() {
		DB db = new DB();
		String row1[] = {"1A", "1B", "1C"};
		String row2[] = {"2A", "2B", "2C"};
		db.createTable("MyTable", 3);
		db.insert("MyTable", row1);
		db.insert("MyTable", row2);
		assertEquals(2, db.getTable("MyTable").numRows());
	}
	
	public void testSelect() {
		DB db = new DB();
		db.createTable("MyTable", 3);
		String row1[] = {"1A", "1B", "1C"};
		String row2[] = {"2A", "2B", "2C"};
		String row3[] = {"3A", "2B", "3C"};
		db.insert("MyTable", row1);
		db.insert("MyTable", row2);
		db.insert("MyTable", row3);
		DBTable tab = db.select("MyTable", 1, "2B");
		assertEquals(2, tab.numRows());
		assertEquals("2A", tab.get(0,0));
		assertEquals("3A", tab.get(1,0));
	}
	
	public void testJoin() {
		DB db = new DB();
		db.createTable("MyTable1", 3);
		db.createTable("MyTable2", 2);
		String row11[] = {"1A", "1B", "1C"};
		String row12[] = {"2A", "2B", "2C"};
		String row13[] = {"3A", "2B", "3C"};
		String row21[] = {"2B", "1B'"};
		db.insert("MyTable1", row11);
		db.insert("MyTable1", row12);
		db.insert("MyTable1", row13);
		db.insert("MyTable2", row21);

		DBTable jtab = db.join("MyTable1", "MyTable2", 1, 0);
		assertEquals(2, jtab.numRows());
		assertEquals(5, jtab.nColumns);
	}
}
