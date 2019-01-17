import java.io.IOException;



/**
 * Main
 */
public class Main {

    /*
        Main entry point
    */
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setLogging(false, true, true);
        logger.setWaitingForUser(false, false, false);
        battleTest(logger);
        // kangarooGeneratorTest(logger);
        // menuTest(logger);
        // fileTester(logger);
        // testWriteKangaroosToFile();
        
    }

    /* 
        Seperate testing methods to test individual functionalities
        Feel free to create new test methods for your testing needs
        and call them in main() 
    */
    public static void battleTest(Logger logger) {
        // For testing the battle system
        Battle battle = new Battle(logger);
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroosFromFile("files/kangaroosStats.csv");
        Result result = battle.runTournament(kangaroos);
        for (Fighter kangaroo : kangaroos) {
            System.out.println(kangaroo.getStatistics().getPrintStr());
        }
        System.out.println(result.getWinner().getName());
        HistoricalDatas hd = new HistoricalDatas(logger);
        hd.WriteResultToFile(result);
    } 

    public static void kangarooGeneratorTest(Logger logger) {
        // For testing Kangaroo generation
        KangarooGenerator k = new KangarooGenerator();
    }

    public static void menuTest(Logger logger) {
        Menu menu = new Menu(logger);
        menu.handleMenu();
    }
    
    public static void fileTester(Logger logger) {
        FileManager fileManager = new FileManager();
        try {
            String[][] s = fileManager.read("files/goat.csv");
           
            logger.tablePrinter.printTable(s);
            fileManager.write("files/output", s);
        } catch (IOException e) {
            System.out.println(e);
        }
    
    }
    public static void testWriteKangaroosToFile(){
        FileManager fm = new FileManager();
        KangarooGenerator kangarooGenerator = new KangarooGenerator(fm);
        Kangaroo[] kangaroos = kangarooGenerator.createKangaroosFromFile("files/kangaroosStats.csv");
        //kangarooGenerator.writeKangaroosToFile(kangaroos);
        kangarooGenerator.createKangaroosFromFile();
        for (Kangaroo var : kangaroos) {
            System.out.println(var.getName());
        }
    }
}