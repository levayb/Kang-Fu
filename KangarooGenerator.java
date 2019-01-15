import java.util.Random;

/**
 * KangarooGenerator
 */
public class KangarooGenerator {

    public Kangaroo createKangaroo(String name, int health, int damageReduction, int attack){
        Kangaroo kangaroo = new Kangaroo(name, health, damageReduction, attack);
        return kangaroo;
    }
                        
    public Kangaroo[] createKangaroos(int number){

        Kangaroo[] kangaroos = new Kangaroo[number];
        String[] names = {"Killer", "Józsi", "Joe", "Gizi", "Pakkó", "Robertó", "Chuck Norris", 
                            "Jimmi", "Oszkár", "Skippy", "Immre a pusztító", "Chicitó", 
                            "Consuela", "Róóóóland", "Anyád", "Lajkó", "Körszakáll", "Tarzan",
                            "Jenő", "Werner", "Piroska", "Nagyanyád", "Jácint", "Jefferson", "Nyenyere",
                            "Tesco", "Java", "Kökörcsin", "Pára", "Nyúl", "Én", "Kurbli"};

        int rnd = new Random().nextInt(names.length);
        if (number > names.length) {
            number = names.length;
        }
        for (int i = 0; i < number; i++) {
            String name = names[i];
            Random rnd2 = new Random();
            int health = rnd2.nextInt((100 - 60) + 1) + 60; 
            int damageReduction = rnd2.nextInt((10 - 5) + 1) + 5;
            int attack = rnd2.nextInt((10 - 5) + 1) + 5; 

            kangaroos[i] = this.createKangaroo(name, health, damageReduction, attack);
        }
        return kangaroos;
    }

}