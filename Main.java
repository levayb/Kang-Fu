import java.util.*;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        battleTest();
    }
    public static void battleTest() {
        //Menu menu = new Menu();
                                    
        Battle battle = new Battle();
        KangarooGenerator k = new KangarooGenerator();
        Fighter[] kangaroos = k.createKangaroos(32);
        battle.runRound(kangaroos);

        // System.out.println(kangaroos[10].getName());
        //battle.runRound(kangaroos);
    } 
    public void kangarooGeneratorTest() {
        
    }
    


}