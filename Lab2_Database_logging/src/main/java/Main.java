public class Main {

    public static void main(String[] args) {
        DB db1 = new DB();
        System.out.println(db1.getLogs().toString());

        db1 = new TextLogger(db1);
        System.out.println(db1.getLogs().toString());

        db1 = new DBLogger(db1);
        System.out.println(db1.getLogs().toString());

        db1 = new TextLogger(db1);
        System.out.println(db1.getLogs().toString());

    }

}
