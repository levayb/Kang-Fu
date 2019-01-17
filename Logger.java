import java.util.Scanner;

/**
 * Logger
 */
public class Logger {
    public TablePrinter tablePrinter = new TablePrinter();
    private boolean battleLogging = true;    
    private boolean roundLogging = true;
    private boolean tournamentLogging = true;
    private boolean waitForUserInBattles = true;
    private boolean waitForUserInRounds = false;
    private boolean waitForUserInTournaments = true;
    private Scanner scanner = new Scanner(System.in);

    public Logger() {
    }

    public void log(String type, String message) {
        System.out.println(type.toUpperCase() + " " + message);
    }

    public void sysOutStringData(String data) {
        System.out.println(data);
    }

    public void sysOutintData(int data) {
        System.out.println(data);
    }

    public void winMsg(String name) {
        System.out.println(name + " has won!");
    }

    public void messageDekor(String msg) {
        int sMax = 45;
        String star = "";
        int sPart = (sMax - msg.length()) / 2;
        for (int i = 0; i < sPart; i++) {
            star += "*";
        }
        System.out.println("\n" + star + msg + star + "\n");
    }

    // public  void dekor() {
    //     int sMax = 45;
    //     String star = "";
    //     for (int i = 0; i < sMax; i++) {
    //         star += "*";
    //     }
    //     System.out.println("\n" + star);
    // }

    public void setLogging(boolean battle_logging, boolean round_logging, boolean tournament_logging) {
        battleLogging = battle_logging;
        roundLogging = round_logging;
        tournamentLogging = tournament_logging;
    }

    public void setWaitingForUser(boolean battles, boolean rounds, boolean tournaments) {
        waitForUserInBattles = battles;
        waitForUserInRounds = rounds;
        waitForUserInTournaments = tournaments;
    }

    public void logBattle(String message) {
        if (battleLogging) {
            System.out.println(message);
            if (waitForUserInBattles) {
                scanner.nextLine();
            }
        }
    }

    public void logRound(String message) {
        if (roundLogging) {
            System.out.println(message);
            if (waitForUserInRounds) {
                scanner.nextLine();
            }
        }
    }

    public void logSimpleMsg(String msg) {
        System.out.println(msg);
    }
} 