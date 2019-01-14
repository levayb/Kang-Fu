/**
 * PairGenerator
 */ 
import java.util.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
public class PairGenerator {

    public PairGenerator() {
    }

    public Object[][] pairMaker(Object[] objects) throws ValueException{
        if (objects.length % 2 != 0){
            throw new ValueException();
        }
        Random random = new Random();
        Array[][] pairs = new Array[objects.length / 2][2]; 
        int maxObject = objects.length;
        int index = 0;
        while (maxObject > 2) {
            for (int i = 0; i < 2; i = i++) {
                int choice = random.nextInt(maxObject);
                pairs[index][i] = objects[choice];
                objects[choice] = objects[maxObject-1]; 
                maxObject -= 1;
            }
            index ++;
        }
    }
}