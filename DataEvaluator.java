/**
 * DataEvaluator :
 * It is responsible for evaluating the generated historical dataset
 * that you have to generate in generateHistoricalDatas.
 * It has the following constructor:
 * DataEvaluator(HistoricalDatas historicalDatas, Logger logger)
 * It has the following methods:
 * run()
 * it returns a Result instance to inform us about
 * the end of the playing and it stores the evaluated result.
 */

public class DataEvaluator {
    private Logger logger;
    private HistoricalDatas historicalDatas;

    public DataEvaluator(HistoricalDatas historicalDatas, Logger logger){
        this.historicalDatas = historicalDatas;
        this.logger = logger;
    }

    public void getMax(String filename, int index, String maxTypeLabel) {
        String[][] theBestContestant = historicalDatas.readResultFromFile(filename);
        int max = 0;
        String maxId;
        for (int i = 0; i < theBestContestant.length; i++) {
            if (max < Integer.parseInt(theBestContestant[i][index])) {
                max = theBestContestant[i][index];
                maxId = theBestContestant[i][0];
            }
        }
        logger.logSimpleMsg(maxTypeLabel + " Id is: " + maxId);
    }

    // public void sumStat(String filename) {

    // }
}