/**
 * Fighter
 */
public class Fighter {

    protected String name;
    protected int health; 
    protected int defense;
    protected int attack; 

    public Fighter(String name, int health, int defense, int attack) {
        this.name = name;
        this. health = health;
        this.defense = defense;
        this.attack = attack;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
    
    public int getDefense() {
        return this.defense;
    }

    public int getattack() {
        return this.attack;
    }

    public boolean isDead() {
        if(this.health <= 0){
            return true;
        }else{
            return false;
        }
    }


}