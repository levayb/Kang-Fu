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

    public Kangaroo createKangaroo(String name, int health, int damageReduction, int attack, int defense){
        
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack, defense);
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
            int attack = rnd.nextInt(40) + 10; 
            int defense = rnd.nextInt(40) + 60; 
            kangaroos[i] = this.createKangaroo(name, health, damageReduction, attack, defense);
        }
        return kangaroos;
    }
    public void writeKangaroosToFile(Kangaroo[] kangaroos){
        String[][] kangarooStats = new String[kangaroos.length][5];
        int index = 0;
        for (Kangaroo kangaroo : kangaroos) {
            kangarooStats[index][0] = kangaroo.getName();
            kangarooStats[index][1] = Integer.toString(kangaroo.getHealth());
            kangarooStats[index][2] = Integer.toString(kangaroo.getdamageReduction());
            kangarooStats[index][3] = Integer.toString(kangaroo.getattack());
            kangarooStats[index][4] = Integer.toString(kangaroo.getDefense());
            index++;
        }
        try {
            fileManager.write("files/kangaroosStats.csv", kangarooStats);
        } catch (IOException e) {
            }
    }

}