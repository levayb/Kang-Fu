import java.util.*;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test() {
        // Tester block
        /*
        // Tester blocka
        Battle battle = new Battle();
        System.out.println("Test print");
        Fighter f1 = new Fighter("Józsi", 200, 10, 10);
        Fighter f2 = new Fighter("Pista", 100, 10, 10);
        Fighter winner = battle.runFight(f1, f2);
        System.out.println(winner.getName());
        
        TablePrinter p = new TablePrinter();
        String[][] s = new String[][] {
                                      {"dfsdf", "sdfsdfasd", "sdgsdgasfs"},
                                      {"dfsdf", "sdfssd", "sdgsdgasfs"},
                                      {"dfsdf", "sdfsdfasd", "sdgsdgasfs"},
                                      {"dfsdf", "sdfsdfasd", "sdgsdgasfs"},
                                      {"dfsdf", "sdfasd", "sdgsdgasfs"}
                                      };
        p.printTable(s, "lll");
        */

        // Testing sets
        
        Battle battle = new Battle();
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroos(10);
        
        battle.runRound(kangaroos);
        // System.out.println(kangaroos[10].getName());
        battle.runRound(kangaroos);
        
    }
}