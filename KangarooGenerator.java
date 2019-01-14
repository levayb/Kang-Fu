import java.util.Random;

/**
 * KangarooGenerator
 */
public class KangarooGenerator {
    String[] names = {"Killer", "Józsi", "Joe", "Gizi", "Pakkó", "Robertó", "Chuck Norris", 
                        "Jimmi", "Oszkár", "Skippy", "Immre a pusztító", "Chicitó", 
                        "Consuela", "Róóóóland", "Anyád", "Lajkó", "Körszakáll", "Tarzan"};
    
    boolean[] used = new boolean[names.length];
                        
    public Kangaroo createKangaroo(){

        int rnd = new Random().nextInt(names.length);
        while (!used[rnd]){
            rnd = new Random().nextInt(names.length);
        }
        used[rnd] = true;
        String name = names[rnd];

        Random rnd2 = new Random();
        int health = rnd2.nextInt((100 - 60) + 1) + 60; 
        int damageReduction = rnd2.nextInt((10 - 5) + 1) + 5;
        int attack = rnd2.nextInt((10 - 5) + 1) + 5; 
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack);
        return kangaroo;

    }public Kangaroo[] createKangaroos(int num){
        Kangaroo[] kangaroos = new Kangaroo[num];
        for (int i = 0; i < num; i++) {
            if (this.createKangaroo()) {
                
            }
            kangaroos[i] = this.createKangaroo(); 
        }
        return kangaroos;
    }
}