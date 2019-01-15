import java.util.*;


/**
 * Main
 */
public class Main {

    /*
        Main entry point
    */
    public static void main(String[] args) {
        battleTest();
        kangarooGeneratorTest();
        menuTest();
    }

    /* 
        Seperate testing methods to test individual functionalities
        Feel free to create new test methods for your testing needs
        and call them in main() 
    */
    public static void battleTest() {
        // For testing the battle system
                                    
        Battle battle = new Battle();
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroos(32);
        battle.runRound(kangaroos);
    } 
    public static void kangarooGeneratorTest() {
        // For testing Kangaroo generation
        KangarooGenerator k = new KangarooGenerator();
    }
    public static void menuTest() {
        // For menu system testing
    }
    


}