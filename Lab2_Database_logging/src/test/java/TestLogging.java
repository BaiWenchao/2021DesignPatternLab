import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogging {
    @Test
    public void textFileOtherDBTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        DB logToTextFileOtherDBDB = new LogToTextFileDB(new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH), Util.TEXT_FILE_PATH);
        String row11[] = {"1A", "1B", "1C"};
        String row21[] = {"2B", "1B"};
        logToTextFileOtherDBDB.createTable("MyTable1", 3);
        logToTextFileOtherDBDB.createTable("MyTable2", 2);
        logToTextFileOtherDBDB.insert("MyTable1", row11);
        logToTextFileOtherDBDB.insert("MyTable2", row21);
        DBTable tab = logToTextFileOtherDBDB.select("MyTable1", 1, "1B");
        DBTable jtab = logToTextFileOtherDBDB.join("MyTable1", "MyTable2", 1, 1);
        assertEquals(Util.logList.get(beforeSize), constructInfo(Util.TO_TEXT_FILE, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+1), constructInfo(Util.TO_OTHER_DB, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+2), constructInfo(Util.TO_TEXT_FILE, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+3), constructInfo(Util.TO_OTHER_DB, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+4), constructInfo(Util.TO_TEXT_FILE, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+5), constructInfo(Util.TO_OTHER_DB, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+6), constructInfo(Util.TO_TEXT_FILE, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+7), constructInfo(Util.TO_OTHER_DB, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+8), constructInfo(Util.TO_TEXT_FILE, Util.SELECT));
        assertEquals(Util.logList.get(beforeSize+9), constructInfo(Util.TO_OTHER_DB, Util.SELECT));
        assertEquals(Util.logList.get(beforeSize+10), constructInfo(Util.TO_TEXT_FILE, Util.JOIN));
        assertEquals(Util.logList.get(beforeSize+11), constructInfo(Util.TO_OTHER_DB, Util.JOIN));
        assertEquals(Util.logList.size(), beforeSize+12);
    }

    @Test
    public void otherDBTextFileTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        DB logToOtherDBTextFileDB = new LogToOtherDBDB(new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH), Util.OTHER_DB_PATH);
        String row11[] = {"1A", "1B", "1C"};
        String row21[] = {"2B", "1B"};
        logToOtherDBTextFileDB.createTable("MyTable1", 3);
        logToOtherDBTextFileDB.createTable("MyTable2", 2);
        logToOtherDBTextFileDB.insert("MyTable1", row11);
        logToOtherDBTextFileDB.insert("MyTable2", row21);
        DBTable tab = logToOtherDBTextFileDB.select("MyTable1", 1, "1B");
        DBTable jtab = logToOtherDBTextFileDB.join("MyTable1", "MyTable2", 1, 1);
        assertEquals(Util.logList.get(beforeSize), constructInfo(Util.TO_OTHER_DB, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+1), constructInfo(Util.TO_TEXT_FILE, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+2), constructInfo(Util.TO_OTHER_DB, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+3), constructInfo(Util.TO_TEXT_FILE, Util.CREATE_TABLE));
        assertEquals(Util.logList.get(beforeSize+4), constructInfo(Util.TO_OTHER_DB, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+5), constructInfo(Util.TO_TEXT_FILE, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+6), constructInfo(Util.TO_OTHER_DB, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+7), constructInfo(Util.TO_TEXT_FILE, Util.INSERT));
        assertEquals(Util.logList.get(beforeSize+8), constructInfo(Util.TO_OTHER_DB, Util.SELECT));
        assertEquals(Util.logList.get(beforeSize+9), constructInfo(Util.TO_TEXT_FILE, Util.SELECT));
        assertEquals(Util.logList.get(beforeSize+10), constructInfo(Util.TO_OTHER_DB, Util.JOIN));
        assertEquals(Util.logList.get(beforeSize+11), constructInfo(Util.TO_TEXT_FILE, Util.JOIN));
        assertEquals(Util.logList.size(), beforeSize+12);
    }

    private String constructInfo(String target, String event) {
        return "[" + Util.getCurrentTime() + " " + target + "]:\t" + event;
    }
}
