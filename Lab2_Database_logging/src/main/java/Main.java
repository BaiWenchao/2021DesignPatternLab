public class Main {
    public static void main(String[] args) {

        DB logToTextFileDB = new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH);
        DB logToOtherDBDB = new LogToOtherDBDB(new DB(), Util.OTHER_DB_PATH);
        DB logToOtherDBTextFileDB = new LogToOtherDBDB(new LogToTextFileDB(new DB(), Util.TEXT_FILE_PATH), Util.OTHER_DB_PATH);

        String row11[] = {"1A", "1B", "1C"};
        String row21[] = {"2B", "1B"};

        // CREATE TABLE
        logToOtherDBTextFileDB.createTable("MyTable1", 3);
        logToOtherDBTextFileDB.createTable("MyTable2", 2);

        // INSERT
        logToOtherDBTextFileDB.insert("MyTable1", row11);
        logToOtherDBTextFileDB.insert("MyTable2", row21);

        // SELECT
        DBTable tab = logToOtherDBTextFileDB.select("MyTable1", 1, "1B");

        // JOIN
        DBTable jtab = logToOtherDBTextFileDB.join("MyTable1", "MyTable2", 1, 1);
    }
}
