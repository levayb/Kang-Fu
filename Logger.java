/**
 * Logger
 */
public class Logger {
    private TablePrinter tablePrinter = new TablePrinter();

    public Logger() {
    }

    public  void log(String type, String message) {
        System.out.print(type.toUpperCase() + ": " + message);
    }

    public void sysOutStringData(String data) {
        System.out.println(data);
    }

    public void sysOutintData(int data) {
        System.out.println(data);
    }
}