import java.io.*;



// name, year, nickname, likesCats



public class FileManager {
    public String[][] read(String filename) throws IOException{
        /*
            Reads a file and returns a string matrix from it
        */
        LineNumberReader f = new LineNumberReader(new FileReader(filename));
        int numOfLines = getnumOfLines(f);
        f.mark(500);
        String countFieldString = f.readLine();
        int numOfFields = countFieldString.length() - countFieldString.replace(",", "").length() + 1;
        f.reset();
        
        String[][] outputArray = new String[numOfLines][numOfFields];
        for (int i = 0; i < numOfLines; i++) {
            outputArray[i] = f.readLine().split(",");
            if (outputArray[i].length != numOfFields) {
                throw new IOException("Column length mismatch at line " + Integer.toString(i));
            }
        }
        return outputArray;
    }

    private int getnumOfLines(LineNumberReader f) throws IOException{
        int numOfLines = 1;
        f.mark(5000);
        f.readLine();
        while(f.readLine() != null) {
            numOfLines ++;
        }
        f.reset();
        return numOfLines;
    }

    public String[] readTxt(String filename) throws IOException{
        LineNumberReader f = new LineNumberReader(new FileReader(filename));
        int numOfLines = getnumOfLines(f);
        String[] outputArray = new String[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            outputArray[i] = f.readLine();
        }
        return outputArray;
    }

    public void write(String filename, String[][] inputArray) throws IOException {
        /*
            Writes a string matrix to a file
        */
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        String str = "";
        for (String[] row : inputArray) {
            for (String item : row) {
                str += item + ",";
            }
            str = str.substring(0, str.length() - 1);
            str += "\n";
        }
        str = str.substring(0, str.length() - 1);
        writer.write(str);
        writer.close();
    }
}