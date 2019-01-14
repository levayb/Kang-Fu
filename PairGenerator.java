/**
 * PairGenerator
 */ 
import java.util.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
public class PairGenerator {

    public PairGenerator() {
    }

    public Object[][] pairMaker(Kangaroo[]) throws ValueException{
        if (Kangaroo[].length % 2 != 0){
            throw new ValueException();
        }
        Array[][] figthers = new Array[Kangaroo.length / 2][2];
    }
}