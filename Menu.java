import java.io.IOException;

/**
 * Menu
 */
public class Menu extends BaseMenu {

    public Menu(Logger logger){
        super(logger);
        super.addOption("Fight");
        super.addOption("Show kangaroos stats");
        super.addOption("Show statistics");
        super.addOption("Result");
        super.addOption("Loading kangoroos from file");
        super.addOption("Exit");

    }
    public void handleMenu() {
        KangarooGenerator kangarooGenerator = new KangarooGenerator();
        Kangaroo[] kangaroos = kangarooGenerator.createKangaroosFromFile("files/kangaroosStats.csv");
        FileManager fileManager = new FileManager();
        try {
            String[] asciArt = fileManager.readTxt("kangaroo.txt");
            for (String line : asciArt) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
        
        }
        super.showMenu();

        switch (super.getInput())
        {
            case 1:
                Battle battle = new Battle(logger);
                battle.runTournament(kangaroos);
                break;
            case 2: 
                TablePrinter tablePrinter = new TablePrinter();
                tablePrinter.printTable(kangarooGenerator.readKangaroosStatsFromFile());
                break;
            case 3: 
                System.out.println("test option 3");
                break;
            case 4: 
                System.out.println("test option 4");
                break;
            case 5: 
                System.out.println("test option 5");
                break;
            case 6: 
                break;
        }   
    } 
}