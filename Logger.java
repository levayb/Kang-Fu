/**
 * Logger
 */
public class Logger {
    private static TablePrinter tablePrinter = new TablePrinter();

    public Logger() {
    }

    public static void log(String type, String message) {
        System.out.println(type.toUpperCase() + message);
    }

    public static void sysOutStringData(String data) {
        System.out.println(data);
    }

    public static void sysOutintData(int data) {
        System.out.println(data);
    }

    public static void winMsg(String name) {
        System.out.println(name + " has won!");
    }

    public static void messageDekor(String msg) {
        int sMax = 45;
        String star = "";
        int sPart = (sMax - msg.length()) / 2;
        for (int i = 0; i < sPart; i++) {
            star += "*";
        }
        System.out.println(star + msg + star);
    }

    public static void dekor() {
        int sMax = 45;
        String star = "";
        for (int i = 0; i < sMax; i++) {
            star += "*";
        }
        System.out.println(star);
    }
}