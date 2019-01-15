/**
 * BaseMenu
 */
public class BaseMenu {

    private String[] options = new String[10];
    private int maxOptions = 0;

    protected void showMenu(){

        Logger.messageDekor("Menu options:");
        decorator(options);
        for (String option : options) {
            Logger.sysOutStringData("  " + option);
        }
        decorator(options);

    }
    protected void addOption(String option){
        options[maxOptions] = option;
        this.maxOptions++;

    }
    public void decorator(String[] menuOptions){
        String decorator = "";
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
        Logger.sysOutStringData(decorator);
    }

}