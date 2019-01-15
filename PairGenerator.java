/**
 * PairGenerator
 */ 
import java.util.*;

public class PairGenerator {

    public PairGenerator() {
    }

    public Fighter[][] makePair(Fighter[] objects) throws IllegalArgumentException{
        if (objects.length % 2 != 0){
            throw new IllegalArgumentException();
        }
        Random random = new Random();
        Fighter[][] pairs = new Fighter[objects.length / 2][2];
        int maxObject = objects.length;
        int i = 0;
        while (maxObject > 2) {
            for (int pairMember = 0; pairMember < 2; pairMember++) {
                int choice = random.nextInt(maxObject);
                pairs[i][pairMember] = objects[choice];
                objects[choice] = objects[maxObject-1];
                maxObject -= 1;
            }
            i ++;
        }
        pairs[pairs.length - 1][0] = objects[0];
        pairs[pairs.length - 1][1] = objects[1];

        for (Fighter[] pair : pairs) {
            for (Fighter fighter : pair) {
                try {
                    System.out.println(fighter.id);
                } catch (NullPointerException e) {
                    System.out.println("x");
                }
            }
        }
       
        return pairs;
    }
}