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
        


        Fighter f1 = new Fighter("SSSSSSSSSSSSSSS", 100, 100, 100);
        Fighter f2 = new Fighter("sadfsdafsdafsa", 100, 100, 100);
        Fighter[] fighters = new Fighter[] {new Fighter("Jack", 1, 1, 1),
                                            new Fighter("Jane", 1, 1, 1),
                                            new Fighter("Anyád", 1, 1, 1),
                                            new Fighter("Tarzan", 1, 1, 1),
                                            new Fighter("Róóóóland", 1, 1, 1),
                                            new Fighter("Körszakáll", 1, 1, 1)
                                            };

        PairGenerator p = new PairGenerator();
        p.makePair(fighters);


    }
}