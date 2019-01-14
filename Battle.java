import java.util.Random;

public class Battle {
    
    Fighter[] fighters = new Fighter[10];
    int maxFighters = 2;

    public Fighter runFight(Fighter fighter1, Fighter fighter2) {
        /*
        Runs a complete pair fight until death. Returns winner
        */
        Fighter[] pair = rollForInitiative(fighter1, fighter2);
        while (true) {
            // Debug
            pair[0].attack(pair[1]);
            pair[1].attack(pair[0]);
            // ********
            System.out.print(pair[0].getName());
            System.out.println(pair[0].getHealth());
            System.out.print(pair[1].getName());
            System.out.println(pair[1].getHealth());
            if (pair[1].isDead()) {
                return pair[0];
            } else if (pair[0].isDead()){
                return pair[1];
            }
        }
        
    }
    public void runTournament(Fighter[] fighter) {
        pairGen = new PairGenerator();
        
    }
    private Fighter[] rollForInitiative(Fighter fighter1, Fighter fighter2) {
        /**
        Calculates which fighter starts game. Returns a pair of fighters in the order of initiative
        */
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return new Fighter[] {fighter1, fighter2}; // Test return; initiative rules to be worked out
        } else {
            return new Fighter[] {fighter2, fighter1}; // Test return; initiative rules to be worked out
        }
    }
}