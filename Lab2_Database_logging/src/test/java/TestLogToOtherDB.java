import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogToOtherDB {
    @Test
    public void createTableToOtherDBTest() {
        int beforeSize = Util.logList.size();
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        logToOtherDBDB.createTable("MyTable1", 3);
        String info = "[" + Util.getCurrentTime() + " " + Util.TO_OTHER_DB + "]:\t" + Util.CREATE_TABLE;
        assertEquals(Util.logList.get(beforeSize), info);
        assertEquals(Util.logList.size(), beforeSize+1);
    }

    @Test
    public void insertToOtherDBTest() {
        int beforeSize = Util.logList.size();
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        String row11[] = {"1A", "1B", "1C"};
        logToOtherDBDB.createTable("MyTable1", 3);
        logToOtherDBDB.insert("MyTable1", row11);
        String info = constructInfo(Util.TO_OTHER_DB, Util.INSERT);
        assertEquals(Util.logList.get(beforeSize+1), info);
        assertEquals(Util.logList.size(), beforeSize+2);
    }

    @Test
    public void selectToOtherDBTest() {
        int beforeSize = Util.logList.size();
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        String row11[] = {"1A", "1B", "1C"};
        logToOtherDBDB.createTable("MyTable1", 3);
        logToOtherDBDB.insert("MyTable1", row11);
        DBTable tab = logToOtherDBDB.select("MyTable1", 1, "1B");
        String info = constructInfo(Util.TO_OTHER_DB, Util.SELECT);
        assertEquals(Util.logList.get(beforeSize+2), info);
        assertEquals(Util.logList.size(), beforeSize+3);
    }

    @Test
    public void joinToOtherDBTest() {
        int beforeSize = Util.logList.size();
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        String row11[] = {"1A", "1B", "1C"};
        String row21[] = {"2B", "1B"};
        logToOtherDBDB.createTable("MyTable1", 3);
        logToOtherDBDB.createTable("MyTable2", 2);
        logToOtherDBDB.insert("MyTable1", row11);
        logToOtherDBDB.insert("MyTable2", row21);
        DBTable jtab = logToOtherDBDB.join("MyTable1", "MyTable2", 1, 1);
        String info = constructInfo(Util.TO_OTHER_DB, Util.JOIN);
        assertEquals(Util.logList.get(beforeSize+4), info);
        assertEquals(Util.logList.size(), beforeSize+5);
    }

    private String constructInfo(String target, String event) {
        return "[" + Util.getCurrentTime() + " " + target + "]:\t" + event;
    }
}
