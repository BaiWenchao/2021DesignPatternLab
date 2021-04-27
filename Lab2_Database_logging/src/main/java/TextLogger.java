import java.util.List;

public class TextLogger extends Logger{
    DB db;
    public TextLogger(DB db){
        this.db = db;
    }

    public List<String> getLogs() {
        List<String> new_log = db.getLogs();
        String log_content = "log to text";
        new_log.add(log_content);
        return new_log;
    }
}
