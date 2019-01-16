import java.util.Scanner;

/**
 * Logger
 */
public class Logger {
    private static TablePrinter tablePrinter = new TablePrinter();
    private static boolean battleLogging = true;    
    private static boolean roundLogging = true;
    private static boolean tournamentLogging = true;
    private static boolean waitForUserInBattles = true;
    private static boolean waitForUserInRounds = true;
    private static boolean waitForUserInTournaments = true;
    private static Scanner scanner = new Scanner(System.in);

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

    public static void setLogging(boolean battle_logging, boolean round_logging, boolean tournament_logging) {
        battleLogging = battle_logging;
        roundLogging = round_logging;
        tournamentLogging = tournament_logging;
    }

    public static void setWaitingForUser(boolean battles, boolean rounds, boolean tournaments) {
        waitForUserInBattles = battles;
        waitForUserInRounds = rounds;
        waitForUserInTournaments = tournaments;
    }

    public static void logBattle(String message) {
        if (battleLogging) {
            System.out.println(message);
            if (waitForUserInBattles) {
                scanner.nextLine();
            }
        }
    }
    
    public static void logRound(String message) {
        if (roundLogging) {
            System.out.println(message);
            if (waitForUserInRounds) {
                scanner.nextLine();
            }
        }
    }
} 