import java.io.IOException;



/**
 * Main
 */
public class AronTest {

    /*
        Main entry point
    */
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.setLogging(false, true, true);
        logger.setWaitingForUser(false, false, false);
        // battleTest(logger);
        // kangarooGeneratorTest(logger);
        // menuTest(logger);
        fileTester(logger);
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
        // hd.WriteResultToFile(result);
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
        HistoricalDatas hd = new HistoricalDatas(logger);
        hd.readResultFromFile();
        
    
    }
    public static void testWriteKangaroosToFile(){
        FileManager fm = new FileManager();
        KangarooGenerator kangarooGenerator = new KangarooGenerator(fm);
        Kangaroo[] kangaroos = kangarooGenerator.createKangaroos(16);
        kangarooGenerator.writeKangaroosToFile(kangaroos);
    }
}