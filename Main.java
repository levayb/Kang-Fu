/**
 * Main
 */
public class Main {

    /*
        Main entry point
    */
    public static void main(String[] args) {
        //battleTest();
        //kangarooGeneratorTest();
        menuTest();
    }

    /* 
        Seperate testing methods to test individual functionalities
        Feel free to create new test methods for your testing needs
        and call them in main() 
    */
    public static void battleTest() {
        // For testing the battle system
        Logger logger = new Logger();
        logger.setLogging(true, true, true);
        Battle battle = new Battle(logger);
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroos(8);
        battle.runTournament(kangaroos);
        
    } 
    public static void kangarooGeneratorTest() {
        // For testing Kangaroo generation
        KangarooGenerator k = new KangarooGenerator();
    }
    public static void menuTest() {
        Menu menu = new Menu();
        menu.handleMenu();
    }
    


}