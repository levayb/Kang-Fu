import java.util.Random;

public class Battle {
    
    int maxFighters = 2;

    private Fighter[] rollForInitiative(Fighter fighter1, Fighter fighter2) {
        /**
        Calculates which fighter starts game. Returns a pair of fighters in the order of initiative
        */
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            return new Fighter[] {fighter1, fighter2};
        } else {
            return new Fighter[] {fighter2, fighter1};
        }
    }

    public Fighter runFight(Fighter fighter1, Fighter fighter2) {
        /*
        Runs a complete pair fight until death. Returns winner
        */
        Fighter[] pair = rollForInitiative(fighter1, fighter2);
        // Show contestants
        Logger.messageDekor("CONTESTANTS");
        pair[0].displayData();
        pair[1].displayData();
        Logger.dekor();

        // Main fight cycle
        while (true) {
            pair[0].attack(pair[1]);
            pair[1].attack(pair[0]);
            if (pair[1].isDead()) {
                Logger.messageDekor("VICTORY");
                Logger.winMsg(pair[0].getName());
                Logger.dekor();
                return pair[0];
            } else if (pair[0].isDead()){
                Logger.messageDekor("VICTORY");
                Logger.winMsg(pair[1].getName());
                Logger.dekor();
                return pair[1];
            }
        }
    }
    public Fighter[] runRound(Fighter[] fighters) {
        // Init, regenerate and display
        Logger.messageDekor("ROUND CONTESTANTS");
        for (Fighter fighter : fighters) {
            fighter.regenerate();
            
        }
        PairGenerator pairGen = new PairGenerator();
        Fighter[][] pairs = pairGen.makePair(fighters);
        Fighter[] winners = new Fighter[fighters.length / 2];
        int i = 0;
        for (Fighter[] pair : pairs) {
            winners[i] = this.runFight(pair[0], pair[1]);
            i++;
        }
        // Display winners
        for (Fighter f : winners) {
            // System.out.println(f.getName());
            f.displayData();
        }
        return winners;
    }
    public void runTournament(Fighter[] contestants) {
        while(contestants.length > 1) {
            contestants = this.runRound(contestants);
        }
        
    }
}