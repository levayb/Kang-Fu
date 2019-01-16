import java.util.Scanner;
/**
 * BaseMenu
 */
public class BaseMenu {

    private String[] options = new String[6];
    private int maxOptions = 0;
    protected Logger logger;

    public BaseMenu(Logger logger) {
        this.logger = logger;
    }

    protected void showMenu(){

        logger.messageDekor("Menu options:");
        decorator(options);
        for (int i = 0; i < maxOptions; i++) {
            logger.sysOutStringData(Integer.toString(i + 1) + " " + options[i]);
        }
        decorator(options);

    }
    protected void addOption(String option){
        options[maxOptions] = option;
        this.maxOptions++;


    }
    public void decorator(String[] menuOptions){
        String decorator = "🦘";
        int index = 0; 
        int elementLength = menuOptions[0].length();
        for(int i=1; i< menuOptions.length; i++) {
            if(menuOptions[i].length() > elementLength) {
                index = i; elementLength = menuOptions[i].length();
            }
        }
        for (int i = 0; i < menuOptions[index].length() / 2; i++) {
            decorator += " 🦘";
        }
        logger.sysOutStringData("\n" + decorator + "\n");
    }

    public int getInput(){
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (!validInput) {
            try {
                choice = (Integer.parseInt(sc.nextLine()));
                if (choice > 0 && choice <= options.length) {
                    validInput = true;
                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException e) {
                logger.log("Error ", "Enter a valid menu option number!");
            }
        }
        sc.close();
        return choice; 
        
        
    }

}