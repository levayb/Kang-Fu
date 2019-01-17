import java.util.Random;

public class Battle {
    
    private PairGenerator pairGen = new PairGenerator();
    private int fightNum = 0;
    private int roundNum = 0;
    private Logger logger;

    public Battle(Logger logger) {
        this.logger = logger;
    }

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
        this.fightNum++;
        /*
        Runs a complete pair fight until death. Returns winner
        */
        Fighter[] pair = rollForInitiative(fighter1, fighter2);
        // Show contestants
        logger.messageDekor("FIGHT " + Integer.toString(this.fightNum) + " CONTESTANTS");
        this.logger.logRound(pair[0].getDataString());
        pair[1].getDataString();

        // Main fight cycle
        while (true) {
            logger.logBattle(pair[0].attack(pair[1]));
            logger.logBattle(pair[1].attack(pair[0]));
            if (pair[1].isDead()) {
                return this.endFight(pair[0], pair[1]);
            } else if (pair[0].isDead()){
                return this.endFight(pair[1], pair[0]);
            }
        }
    }
    private Fighter endFight(Fighter winner, Fighter loser) {
        winner.announceAsWinner();
        loser.announceAsLoser();
        logger.messageDekor("VICTORY");
        logger.winMsg(winner.getName());
        return winner;
    }
    public Fighter[] runRound(Fighter[] fighters) {
        this.roundNum++;
        this.fightNum = 0;
        // Init, regenerate and display
        logger.messageDekor("ROUND " + Integer.toString(this.roundNum) + " CONTESTANTS");
        for (Fighter fighter : fighters) {
            fighter.regenerate();
            this.logger.logRound(fighter.getDataString());
        }
        // Pre-fight init
        Fighter[][] pairs = pairGen.makePair(fighters);
        Fighter[] winners = new Fighter[fighters.length / 2];
        // Running fights
        int i = 0;
        for (Fighter[] pair : pairs) {
            winners[i] = this.runFight(pair[0], pair[1]);
            i++;
        }
        // Display winners
        logger.messageDekor("Round Winners");
        for (Fighter f : winners) {
            // System.out.println(f.getName());
            this.logger.logBattle(f.getDataString());
        }
        return winners;
    }
    public Fighter runTournament(Fighter[] fighters) {
        Fighter[] contestants = new Fighter[fighters.length];
        int i = 0;
        for (Fighter fighter : fighters) {
            contestants[i] = fighter;
            i++;
        }
        logger.messageDekor("TOURNAMENT");
        while(contestants.length > 1) {
            contestants = this.runRound(contestants);
        }
        Fighter tournamentWinner = contestants[0];
        
        return tournamentWinner;
    }
}