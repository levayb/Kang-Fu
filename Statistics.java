/**
 * Statistics:
 * Stores statistical data about the simulation:
 * 1.) How many number of simulations were run.
 * 2.) How many data points.
 * 3.) How long it take to run all the simulations.
 * 4.) Winning/losing percentages.
 * .
 * .
 * .
 * n.) etc.
 * It depends on the selected game.
 */

public class Statistics {
    protected int hitCount = 0;
    protected int missCount = 0;
    protected int sufferedHitCount = 0;
    protected int simCount = 0;
    protected int winCount = 0;
    protected int loseCount = 0;
    private String name = "";
    private int id = 0;

    public Statistics(Fighter fighter){
        id = fighter.getId();
        name = fighter.getName();
    }
    
    public Statistics(int id, int wins, int losses, int hitCount, int missCount, int sufferedHitCount) {
        this.winCount = wins;
        this.loseCount = losses;
        this.hitCount = hitCount;
        this.missCount = missCount;
        this.sufferedHitCount = sufferedHitCount;
    }

    public int countSimulations() {
        this.simCount += 1;
        return simCount;
    }

    public int countwins() {
        this.winCount += 1;
        return winCount;
    }

    public int countloses() {
        this.loseCount += 1;
        return loseCount;
    }

    public int countHits() {
        return this.hitCount;
    }

    public int countMisses() {
        return this.missCount;
    }

    public int countSufferedHits() {
        return this.sufferedHitCount;
    }

    public float winnerPercentage() {
        int winStat = this.simCount / this.winCount;
        return winStat;
    }

    public float looserPercentage() {
        int loseStat = this.simCount / this.loseCount;
        return loseStat;
    }
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void incrementWin() {
        this.winCount++;
    }

    public void incrementLose() {
        this.loseCount++;
    }

    public void incrementHits() {
        this.hitCount++;
    }

    public void incrementMisses() {
        this.missCount++;
    }

    public void incrementSufferedHits() {
        this.sufferedHitCount++;
    }

    public String getPrintStr() {
        String str = "";
        str += "Id: " + Integer.toString(this.id)  + "\n";
        str += "Name: " + this.name + "\n";
        str += "Victories: " + Integer.toString(this.winCount) + "\n";
        str += "Defeats: " + Integer.toString(this.loseCount) + "\n";
        str += "Hits: " + Integer.toString(this.hitCount) + "\n";
        str += "Misses: " + Integer.toString(this.missCount) + "\n";
        str += "Suffered hits: " + Integer.toString(this.sufferedHitCount) + "\n";
        return str;
    }
}