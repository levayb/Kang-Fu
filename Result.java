/**
 * Result
 */
public class Result {
    Statistics[] statistics;
    Fighter winner;

    public Result(){
        
    }

    public Result(Fighter[] fighters, Fighter winner){
        addBatch(fighters);
        this.winner = winner;
    }

    public Fighter getWinner() {
        return winner;
    }
    public void addBatch(Fighter[] kangaroos) {
        statistics = new Statistics[kangaroos.length];
        int i = 0;
        for (Fighter kangaroo : kangaroos) {
            statistics[i] = kangaroo.getStatistics();
            i++;
        }
    }

    public void addBatch(Statistics[] statistics) {
        this.statistics = statistics;
    }

    public Statistics[] getStatistics() {
        return statistics;
    }
}