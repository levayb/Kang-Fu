import java.util.Random;

/**
 * KangarooGenerator
 */
public class KangarooGenerator {

    private int kangarooOrder;

    public Kangaroo createKangaroo(){
        String[] names = {"Killer", "Józsi", "Joe", "Gizi", "Pakkó", "Robertó",
                            "Jimmi", "Oszkár", "Skippy", "Immre a pusztító"};
        int rnd = new Random().nextInt(names.length);
        String name = names[rnd];
        Random rnd2 = new Random();
        int health = rnd2.nextInt((100 - 60) + 1) + 60; 
        int damageReduction = rnd2.nextInt((10 - 5) + 1) + 5;
        int attack = rnd2.nextInt((10 - 5) + 1) + 5; 
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack);
        return kangaroo;
    }
}