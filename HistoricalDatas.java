import java.io.*;
/**
 * HistoricalDatas: Contains the simulation data.
 * 
 * It has the following methods:
 * 
 * generateData() writes one simulated round to a file. We recommend the CSV
 * format. load() loads the content of an instance of a HistoricalDatas and
 * returns it. Output: A clear output where with we can see how to play in the
 * selected game (which horse to bet on, which numbers to play, what team to bet
 * on) to maximize our chance of winning. So that we can use it to play with the
 * biggest chance and win!
 */

public class HistoricalDatas {
    private Logger logger;

    public HistoricalDatas(Logger logger) {
        this.logger = logger;
    }

    public void WriteResultToFile(Result result) {
        Statistics[] stat = result.getStatistics();
        String[][] statMatrix = new String[stat.length][6];
        for (int i = 0; i < stat.length; i++) {
            statMatrix[i][0] = Integer.toString(stat[i].getId());
            statMatrix[i][1] = Integer.toString(stat[i].countwins());
            statMatrix[i][2] = Integer.toString(stat[i].countloses());
            statMatrix[i][3] = Integer.toString(stat[i].countHits());
            statMatrix[i][4] = Integer.toString(stat[i].countMisses());
            statMatrix[i][5] = Integer.toString(stat[i].countSufferedHits());
        }
        FileManager writeMatrix = new FileManager();
        try {
            String[][] files = writeMatrix.read("files/tournaments/dbase.csv");
            int fileNum = Integer.parseInt(files[files.length - 1][0]);
            fileNum++;
            String logFileName = Integer.toString(fileNum);
            writeMatrix.write("files/tournaments/" + logFileName +".csv", statMatrix);
            updateDbaseFile(writeMatrix, files, fileNum);
        } catch (IOException e) {
        }
    }

    private void updateDbaseFile(FileManager fileManager, String[][] files, int fileNum) throws IOException{
        String[][] output = new String[files.length + 1][1];
        for (int i = 0; i < files.length; i++) {
            output[i][0] = files[i][0];
        }
        output[output.length - 1][0] = Integer.toString(fileNum);
        fileManager.write("files/tournaments/dbase.csv", output);

    }
  

    private void writeResToConsole(Result[] results) {
        for (Result result : results) {
            Statistics[] stats = result.getStatistics();
            for (Statistics stat : stats) {
                logger.logSimpleMsg(stat.getPrintStr());
                
            }
        }
    }

    private Result[] attemptToRead() throws IOException{
        String dataBaseLocation = "files/tournaments/dbase.csv";
        FileManager fileManager = new FileManager();
        String[][] files = fileManager.read(dataBaseLocation);
        Result[] result = new Result[files.length];
        for (int i = 0; i < files.length; i++) {
            String[][] tournaments = fileManager.read("files/tournaments/" + files[i][0] + ".csv");
            Statistics[] stats = new Statistics[tournaments.length];
            for (int j = 0; j < tournaments.length; j++) {
                int id = Integer.parseInt(tournaments[j][0]);
                int wins = Integer.parseInt(tournaments[j][1]);
                int losses = Integer.parseInt(tournaments[j][2]);
                int hitCount = Integer.parseInt(tournaments[j][3]);
                int missCount = Integer.parseInt(tournaments[j][4]);
                int sufferedHitCount = Integer.parseInt(tournaments[j][5]);
                stats[j] = new Statistics(id, wins, losses, hitCount, missCount, sufferedHitCount);
            }
            result[i] = new Result();
            result[i].addBatch(stats);
        }
        return result;
    }

    public void readResultFromFile() {
        Result[] res = new Result[2];
        try {
            res = attemptToRead();
        } catch (Exception e) {
            System.out.println(e);
        }
        writeResToConsole(res);
        
    }
    
    
}