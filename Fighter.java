/**
 * Fighter
 */
public class Fighter {

    private String name;
    private int health; 
    private int defense;
    private int attack; 

    public Fighter(String name, int health, int defense, int attack){
    }

    public String getName(){
        return this.name;
    }

    public boolean isDead(){
        if(this.health <= 0){
            return true;
        }else{
            return false;
        }
    }


}