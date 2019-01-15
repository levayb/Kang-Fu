import java.util.Random;

public class Battle {
    
    Fighter[] fighters = new Fighter[10];
    int maxFighters = 2;

    public Fighter runFight(Fighter fighter1, Fighter fighter2) {
        /*
        Runs a complete pair fight until death. Returns winner
        */
        Fighter[] pair = rollForInitiative(fighter1, fighter2);
        
        // System.out.println("******************CONTESTANTS*****************");
        // System.out.print(pair[0].getName());
        // System.out.println(pair[0].getHealth());
        // System.out.print(pair[1].getName());
        // System.out.println(pair[1].getHealth());
        // System.out.println("****************************************");
        Logger.messageDekor("CONTESTANTS");
        Logger.sysOutStringData(pair[0].getName());
        Logger.sysOutintData(pair[0].getHealth());
        Logger.sysOutStringData(pair[1].getName());
        Logger.sysOutintData(pair[1].getHealth());
        Logger.dekor();
        while (true) {
            // Debug
            pair[0].attack(pair[1]);
            pair[1].attack(pair[0]);
            // ********
            if (pair[1].isDead()) {
                Logger.messageDekor("VICTORY");
                Logger.winMsg(pair[0].getName());
                Logger.dekor();
                // System.out.println("*****************VICTORY******************");
                // System.out.println(pair[0].getName() + " has won!");
                // System.out.println("****************************************");
                return pair[0];
            } else if (pair[0].isDead()){
                Logger.messageDekor("VICTORY");
                Logger.winMsg(pair[1].getName());
                Logger.dekor();
                // System.out.println("*****************VICTORY******************");
                // System.out.println(pair[1].getName() + " has won!");
                // System.out.println("****************************************");
                return pair[1];
            }
        }
        
    }
    public void runRound(Fighter[] fighters) {
        PairGenerator pairGen = new PairGenerator();
        Fighter[][] pairs = pairGen.makePair(fighters);
        Fighter[] winners = new Fighter[fighters.length / 2];
        int i = 0;
        for (Fighter[] pair : pairs) {
            winners[i] = this.runFight(pair[0], pair[1]);
            i++;
        }
        for (Fighter f : winners) {
            // System.out.println(f.getName());
            Logger.sysOutStringData(f.getName());
        }
     
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