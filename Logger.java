/**
 * Logger
 */
public class Logger {
    private static TablePrinter tablePrinter = new TablePrinter();
    private static Menu menu = new Menu();

    public Logger() {
    }

    public static void log(String type, String message) {
        System.out.print(type.toUpperCase() + ": " + message);
    }

    public static void sysOutStringData(String data) {
        System.out.println(data);
    }

    public static void sysOutintData(int data) {
        System.out.println(data);
    }
}