import java.io.IOException;
import java.util.Random;

/**
 * KangarooGenerator
 */
public class KangarooGenerator {

    private FileManager fileManager;
    private String fileName;

    public KangarooGenerator(){
    }

    public KangarooGenerator(FileManager fileManager){
        this.fileManager = fileManager;
    }

    public Kangaroo createKangaroo(String name, int health, int damageReduction, int attack, int defense){
        
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack, defense);
        return kangaroo;
    }
    public Kangaroo createKangaroo(int id, String name, int health, int damageReduction, int attack, int defense){
        
        Kangaroo kangaroo = new Kangaroo(id, name, health, damageReduction, attack, defense);
        return kangaroo;
        //return kangaroo;
    }
    public Kangaroo[] createKangaroos(int number){

        Kangaroo[] kangaroos = new Kangaroo[number];

        String[] names = {"Killer", "Dzsefferzon", "Joe", "Gizi", "Pakkó", "Robertó", "Chuck Norris", 
                            "Jimmi", "Oszkár", "Skippy", "Immre a pusztító", "Chicitó", 
                            "Consuela", "Róóóóland", "Anyád", "Lajkó", "Körszakáll", "Tarzan",
                            "Jenő", "Werner", "Piroska", "Nagyanyád", "Jácint", "Józsi", "Nyenyere",
                            "Tesco", "Java", "Kökörcsin", "Pára", "Nyúl", "Én", "Kurbli"};

        if (number > names.length) {
            number = names.length;
        }
        for (int i = 0; i < number; i++) {

            String name = names[i];
            Random rnd = new Random();
            int health = rnd.nextInt((100 - 60) + 1) + 60; 
            int damageReduction = rnd.nextInt((10 - 5) + 1) + 5;
            int attack = rnd.nextInt(40) + 10; 
            int defense = rnd.nextInt(40) + 60; 
            kangaroos[i] = this.createKangaroo(name, health, damageReduction, attack, defense);
        }
        return kangaroos;
    }
    public void writeKangaroosToFile(Kangaroo[] kangaroos){
        fileName = "files/kangaroosStats.csv";
        String[][] kangarooStats = new String[kangaroos.length][6];


        int index = 1;
        for (Kangaroo kangaroo : kangaroos) {
            kangarooStats[index][0] = Integer.toString(kangaroo.getId());
            kangarooStats[index][1] = kangaroo.getName();
            kangarooStats[index][2] = Integer.toString(kangaroo.getHealth());
            kangarooStats[index][3] = Integer.toString(kangaroo.getdamageReduction());
            kangarooStats[index][4] = Integer.toString(kangaroo.getattack());
            kangarooStats[index][5] = Integer.toString(kangaroo.getDefense());
            index++;
        }
        try {
            fileManager.write("files/kangaroosStats.csv", kangarooStats);
        } catch (IOException e) {
            }
    }
    public Kangaroo[] createKangaroosFromFile(String fileName){
        Kangaroo[] kangaroos;
        String[][] kangarooStats = new String[1][0];
        FileManager fileManager = new FileManager();
        try {
            kangarooStats = fileManager.read(fileName);
        } catch (IOException e) {
            //TODO: handle exception
        }
        kangaroos = new Kangaroo[kangarooStats.length];
        for (int i = 1; i < kangarooStats.length; i++) {
            kangaroos[i] = createKangaroo(Integer.parseInt(kangarooStats[i][0]), 
                                            kangarooStats[i][1], 
                                            Integer.parseInt(kangarooStats[i][2]), 
                                            Integer.parseInt(kangarooStats[i][3]), 
                                            Integer.parseInt(kangarooStats[i][4]),
                                            Integer.parseInt(kangarooStats[i][5]));
            }
        return kangaroos;

    }public Kangaroo[] createKangaroosFromFile(){
        return this.createKangaroosFromFile(fileName);

    }public String[][] readKangaroosStatsFromFile(){
        
        String[][] kangarooStats = new String[0][0];
        String[] temp = new String[6];
        String[][] statsFromFile = new String[0][0];

        FileManager fileManager = new FileManager();
        try {
            statsFromFile = fileManager.read("files/kangaroosStats.csv");
            kangarooStats = new String[statsFromFile.length + 1][6];
            kangarooStats[0][0] = "Id";
            kangarooStats[0][1] = "Name";
            kangarooStats[0][2] = "Health";
            kangarooStats[0][3] = "DamageReduction";
            kangarooStats[0][4] = "Attack";
            kangarooStats[0][5] = "Defense";
        
        for (int i = 1; i < kangarooStats.length; i++) {
            kangarooStats[i] = statsFromFile[i - 1];
            }
        } catch (IOException e) {
            //TODO: handle exception
        }
        
        return kangarooStats;
    }

}