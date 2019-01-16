import java.io.IOException;

/**
 * Menu
 */
public class Menu extends BaseMenu {

    public Menu(Logger logger){
        super(logger);
        super.addOption("Fight");
        super.addOption("Make kangaroos from file");
        super.addOption("Show statistics");
        super.addOption("Result");
        super.addOption("Loading kangoroos from file");
        super.addOption("Exit");

    }
    public void handleMenu() {
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
                System.out.println("test option 1");
                break;
            case 2: 
                System.out.println("test option 2");
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
                System.out.println("test option 6");
                break;
            default:
                System.out.println("Choice must be a value between 1 and 6.");
        }   
    } 
}