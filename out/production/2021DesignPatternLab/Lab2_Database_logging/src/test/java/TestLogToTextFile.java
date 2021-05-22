import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogToTextFile {
    @Test
    public void createTableToTextFileTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        logToTextFileDB.createTable("MyTable1", 3);
        String info = "[" + Util.getCurrentTime() + " " + Util.TO_TEXT_FILE + "]:\t" + Util.CREATE_TABLE;
        assertEquals(Util.logList.get(beforeSize), info);
        assertEquals(Util.logList.size(), beforeSize+1);
    }

    @Test
    public void insertToTextFileTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        String row11[] = {"1A", "1B", "1C"};
        logToTextFileDB.createTable("MyTable1", 3);
        logToTextFileDB.insert("MyTable1", row11);
        String info = constructInfo(Util.TO_TEXT_FILE, Util.INSERT);
        assertEquals(Util.logList.get(beforeSize+1), info);
        assertEquals(Util.logList.size(), beforeSize+2);
    }

    @Test
    public void selectToTextFileTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        String row11[] = {"1A", "1B", "1C"};
        logToTextFileDB.createTable("MyTable1", 3);
        logToTextFileDB.insert("MyTable1", row11);
        DBTable tab = logToTextFileDB.select("MyTable1", 1, "1B");
        String info = constructInfo(Util.TO_TEXT_FILE, Util.SELECT);
        assertEquals(Util.logList.get(beforeSize+2), info);
        assertEquals(Util.logList.size(), beforeSize+3);
    }

    @Test
    public void joinToTextFileTest() {
        int beforeSize = Util.logList.size();
        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        String row11[] = {"1A", "1B", "1C"};
        String row21[] = {"2B", "1B"};
        logToTextFileDB.createTable("MyTable1", 3);
        logToTextFileDB.createTable("MyTable2", 2);
        logToTextFileDB.insert("MyTable1", row11);
        logToTextFileDB.insert("MyTable2", row21);
        DBTable jtab = logToTextFileDB.join("MyTable1", "MyTable2", 1, 1);
        String info = constructInfo(Util.TO_TEXT_FILE, Util.JOIN);
        assertEquals(Util.logList.get(beforeSize+4), info);
        assertEquals(Util.logList.size(), beforeSize+5);
    }

    private String constructInfo(String target, String event) {
        return "[" + Util.getCurrentTime() + " " + target + "]:\t" + event;
    }
}
