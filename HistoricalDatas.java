import java.io.* ;
/**
 * HistoricalDatas: Contains the simulation data.
 * 
 * It has the following methods:
 * 
 * generateData()
 * writes one simulated round to a file. We recommend the CSV format.
 * load()
 * loads the content of an instance of a HistoricalDatas and returns it.
 * Output:
 * A clear output where with we can see how to play in the selected game
 * (which horse to bet on, which numbers to play, what team to bet on)
 * to maximize our chance of winning.
 * So that we can use it to play with the biggest chance and win!
 */

public class HistoricalDatas {
    
    public HistoricalDatas(){
        
    }

    public void fileWriter(String data, String fileName) throws Exception{
        FileWriter writeFile = new FileWriter(fileName);
        BufferedWriter write = new BufferedWriter(writeFile);
        write.write(data);
        write.newLine();
        write.flush();
        write.close();
    }
}