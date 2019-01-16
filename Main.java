/**
 * Main
 */
public class Main {

    /*
        Main entry point
    */
    public static void main(String[] args) {
        Logger logger = new Logger();
        battleTest(logger);
        kangarooGeneratorTest(logger);
        menuTest(logger);
    }

    /* 
        Seperate testing methods to test individual functionalities
        Feel free to create new test methods for your testing needs
        and call them in main() 
    */
    public static void battleTest(Logger logger) {
        // For testing the battle system
        logger.setLogging(false, true, true);
        Battle battle = new Battle(logger);
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroos(8);
        battle.runTournament(kangaroos);
        
    } 
    public static void kangarooGeneratorTest(Logger logger) {
        // For testing Kangaroo generation
        KangarooGenerator k = new KangarooGenerator();
    }
    public static void menuTest(Logger logger) {
        Menu menu = new Menu(logger);
        menu.handleMenu();
    }
    


}