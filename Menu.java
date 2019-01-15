import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

    private int choice;
    private String[] menuOptions = {"Figth", "Make kangoroos", "Loading kangoroos from file", "Statistics", "Result", "Exit"};

    public Menu(){

        do {
            Scanner sc = new Scanner(System.in);
            Logger.sysOutStringData("Enter \"1\", \"2\", \"3\", \"4\", \"5\" or \"6\": ");
            // System.out.print("Enter \"1\", \"2\", \"3\", \"4\", \"5\" or \"6\": ");
            choice = sc.nextInt();

            switch (choice)
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
        } while (choice != 6);
    }
   
}