public class TablePrinter {
    /*
    Prints tables with aligned and justified columns
    */
    public void displayLine(String message) {
        /*
        basic printline method. Can be overwritten as needed to fit particular UI needs
        System.out.println(message);
        */
        System.out.println(message);
    }
    public void printTable(String[][] table) {

        String spacing = "";
        for (int i = 0; i < table[0].length; i++) {
            spacing += "l";
        }
        printTable(table, spacing, 10, "| ");
    }
    public void printTable(String[][] table, String justifyCols) {
        printTable(table, justifyCols, 3, "| ");
    }
    public void printTable(String[][] table, String justifyCols, int extraSpacingLength) {
        printTable(table, justifyCols, extraSpacingLength, "| ");
    }
    public void printTable(String[][] table, String justifyCols, int extraSpacingLength, String border) {
        /*
        Prints table.
        Params:
               - table: table matrix in this format: [rows][columns]
               - justifyCols: character code for justifying columns, l for left, r for right. In a table of three columns, for example,
                              in which the left on is justified left, the middle on right and the right one is again left, it should be
                              like this: "lrl"
               - extraSpacingLength: length of extra spacing between columns
               - Border: border chars between columns
        */
        int rowNum = table.length;
        int colNum = table[0].length;
        int spacingLength = 0;
        String spacingChar =  " ";

        // Calculate max length for each columns
        int[] colMaxLength = new int[rowNum];
        for (int col = 0; col < colNum; col++) {
            for (int row = 0; row < rowNum; row++) {
                try {
                    int length = table[row][col].length();
                    if (colMaxLength[col] < length) {
                        colMaxLength[col] = length;
                    }
                    if (table[row][col] == null) {
                        break;
                    }
                } catch (NullPointerException e) {
                    rowNum = row;
                    break;
                }
            }
        }

        // Print table
        for (int row = 0; row < rowNum; row++) {
            String rowText = "";
            for (int col = 0; col < colNum; col++) {
                if (table[row][col] == null) {
                    break;
                }
                rowText += border;
                spacingLength = colMaxLength[col] - table[row][col].length() + extraSpacingLength;
                String spacing = new String(new char[spacingLength]).replace("\0", spacingChar);
                switch (justifyCols.charAt(col)) {
                    case 'l': rowText += table[row][col] + spacing;
                    break;
                    case 'r':  rowText += spacing + table[row][col];
                    break;
                    default: rowText += table[row][col] + spacing;
                    break;
                } 
            }
            rowText += border;
            displayLine(rowText);
        }
    }
}