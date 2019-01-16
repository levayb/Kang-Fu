import java.io.IOException;
import java.util.Random;

/**
 * KangarooGenerator
 */
public class KangarooGenerator {

    private FileManager fileManager;

    public KangarooGenerator(){
    }

    public KangarooGenerator(FileManager fileManager){
        this.fileManager = fileManager;
    }

    public Kangaroo createKangaroo(String name, int health, int damageReduction, int attack){
        
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack);
        return kangaroo;
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
            int attack = rnd.nextInt((10 - 5) + 1) + 5; 
            kangaroos[i] = this.createKangaroo(name, health, damageReduction, attack);
        }
        return kangaroos;
    }
    public void writeKangaroosToFile(Kangaroo[] kangaroos){
        String[][] kangarooStats = new String[kangaroos.length][4];
        int index = 0;
        for (Kangaroo kangaroo : kangaroos) {
            kangarooStats[0][0] = kangaroo.getName();
            kangarooStats[0][1] = Integer.toString(kangaroo.getHealth());
            kangarooStats[0][2] = Integer.toString(kangaroo.getdamageReduction());
            kangarooStats[0][3] = Integer.toString(kangaroo.getattack());
            index++;
        }
        try {
            fileManager.write("kangaroosStats.csv", kangarooStats);
        } catch (IOException e) {
            }
    }

}