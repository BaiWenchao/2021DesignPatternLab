import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Util {

    // static info
    public static String TEXT_FILE_PATH = "logToTextFile.txt";
    public static String OTHER_DB_PATH = "logToOtherDB.db";

    public static String TO_TEXT_FILE = "TO TEXT FILE";
    public static String TO_OTHER_DB = "TO OTHER DB";

    public static String CREATE_TABLE = "CREATE TABLE";
    public static String INSERT = "INSERT";
    public static String SELECT = "SELECT";
    public static String JOIN = "JOIN";

    // used for test
    public static List<String> logList = new ArrayList<>();

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    // write to the file; register the info to the List; print the info;
    public static void logInfo(String path, String time, String target, String event) {
        String info = "[" + time + " " + target + "]:\t" + event;
        File logFile = new File(path);
        try(FileWriter fw = new FileWriter(logFile, true);
            BufferedWriter bfw = new BufferedWriter(fw)){
            bfw.write(info+"\n");
            logList.add(info);
            System.out.println(info);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
