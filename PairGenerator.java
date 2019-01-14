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
        int index = 0;
        while (maxObject > 2) {
            for (int i = 0; i < 2; i++) {
                int choice = random.nextInt(maxObject);
                pairs[index][i] = objects[choice];
                objects[choice] = objects[maxObject-1]; 
                maxObject -= 1; 
            }
            index ++;
        }
        pairs[pairs.length - 1][0] = objects[0];
        pairs[pairs.length - 1][1] = objects[1];
       
        return pairs;
    }
}