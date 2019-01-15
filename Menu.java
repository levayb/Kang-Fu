import java.util.Scanner;

/**
 * Menu
 */
public class Menu {

    private int choice;
    private String header = " Menu options:";
    private String[] menuOptions = {"Figth", "Make kangoroos", "Loading kangoroos from file", "Exit"};
    private String decorator;

    public Menu(){

        do {
            System.out.println(header);
            decorator(menuOptions);
            for (String option : menuOptions) {
                System.out.println("  " + option);
                
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter \"1\", \"2\", \"3\" or \"4\": ");
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
                default:
                    System.out.println("Choice must be a value between 1 and 4.");
            }   
        } while (choice != 4);
    }
    public void decorator(String[] menuOptions){
        int index = 0; 
        int elementLength = menuOptions[0].length();
        for(int i=1; i< menuOptions.length; i++) {
            if(menuOptions[i].length() > elementLength) {
                index = i; elementLength = menuOptions[i].length();
            }
        }
        for (int i = 0; i < menuOptions[index].length(); i++) {
            decorator += "*";
        }
        System.out.println(decorator);
    }
}