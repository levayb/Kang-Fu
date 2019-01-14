public class Battle {
    
    Fighter[] fighters = new Fighter[10];
    int maxFighters = 2;

    public Fighter runFight(Fighter fighter1, Fighter fighter2) {
        /*
        Runs a complete pair fight until death. Returns winner
        */
        Fighter fighterA;
        Fighter fighterB;
        if (rollForInitiative(fighter1, fighter2) == 1) {
            fighterA = fighter1;
            fighterB = fighter2;
        } else {
            fighterA = fighter2;
            fighterB = fighter1;
        }
        while (true) {
            fighterA.attack(fighterB);
            fighterB.attack(fighterA);
            if (fighterB.isDead()) {
                return fighterA;
            } else if (fighterA.isDead()){
                return fighterB;
            }
        }
        
    }
    private int rollForInitiative(Fighter fighter1, Fighter fighter2) {
        /**
        Calculates which fighter starts game. Returns 1 for fighter1 and 2 for fighter 2
        */
        return 1; // Test return; initiative rules to be worked out
    }
}