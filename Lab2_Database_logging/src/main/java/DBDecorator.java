public class DBDecorator extends DB {
    private DB myRealDB;
    private String path;
    public DBDecorator(DB myRealDB, String path) {
        this.myRealDB = myRealDB;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public DB getMyRealDB() {
        return myRealDB;
    }
}
