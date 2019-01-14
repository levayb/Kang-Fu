public class Battle {
    
    Fighter[] fighters = new Fighters[10];
    int maxFighters = 2;

    public void runFight(Fighter fighter1, Fighter fighter2) {
        boolean gameOver = false;
        Fighter fighterA;
        Fighter fighterB;
        if (rollForInitiative(fighter1, fighter2) == 1) {
            fighterA = fighter1;
            fighterB = fighter2;
        } else {
            fighterA = fighter2;
            fighterB = fighter1;
        }
        while (!gameOver) {
            fighterA.attack(fighter2);
            fighterB.attack(fighter1);
            if (fighter1.isDead() | fighter2.isDead()) {
                gameOver = true;
            }
        }
    }

    private int rollForInitiative(Fighter fighter1, Fighter fighter2) {
        return 1; // Test return; initiative rules to be worked out
    }
}