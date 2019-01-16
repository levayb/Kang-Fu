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
    protected int simCount = 0;
    protected int winCount = 0;
    protected int loseCount = 0;

    public Statistics(){
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

    public float winnerPercentage() {
        int winStat = this.simCount / this.winCount;
        return winStat;
    }

    public float looserPercentage() {
        int loseStat = this.simCount / this.loseCount;
        return loseStat;
    }
}