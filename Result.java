/**
 * Result
 */
public class Result {
    Statistics[] statistics;

    public void Result(){
        
    }
    public void addBatch(Kangaroo[] kangaroos) {
        statistics = new Statistics[kangaroos.length];
        int i = 0;
        for (Kangaroo kangaroo : kangaroos) {
            statistics[i] = kangaroo.getStatistics();
            i++;
        }
    }
    public Statistics[] getStatistics() {
        return statistics;
    }
}