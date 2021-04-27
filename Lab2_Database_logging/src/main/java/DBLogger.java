import java.util.List;

public class DBLogger extends Logger{

    private DB db;
    public DBLogger(DB db){
        this.db = db;
    }

    public List<String> getLogs() {
        List<String> new_log = db.getLogs();
        String log_content = "log to another database";
        new_log.add(log_content);
        return new_log;
    }

}
