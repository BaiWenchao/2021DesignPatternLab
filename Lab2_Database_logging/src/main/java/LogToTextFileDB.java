public class LogToTextFileDB extends DBDecorator {

    public LogToTextFileDB(DB myRealDB, String path) {
        super(myRealDB, path);
    }

    @Override
    public void createTable(String name, int columns) {
        Util.logInfo(getPath(), Util.getCurrentTime(), Util.TO_TEXT_FILE, Util.CREATE_TABLE);
        getMyRealDB().createTable(name, columns);
    }

    @Override
    public void insert(String tableName, String[] row) {
        Util.logInfo(getPath(), Util.getCurrentTime(), Util.TO_TEXT_FILE, Util.INSERT);
        getMyRealDB().insert(tableName, row);
    }

    @Override
    public DBTable select(String tabName, int col, String selector) {
        Util.logInfo(getPath(), Util.getCurrentTime(), Util.TO_TEXT_FILE, Util.SELECT);
        return getMyRealDB().select(tabName, col, selector);
    }

    @Override
    public DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col) {
        Util.logInfo(getPath(), Util.getCurrentTime(), Util.TO_TEXT_FILE, Util.JOIN);
        return getMyRealDB().join(tab1Name, tab2Name, tab1Col, tab2Col);
    }
}
