/**
 * Fighter
 */
public class Fighter {

    protected String name;
    protected int health; 
    protected int damageReduction;
    protected int attack; 

    public Fighter(String name, int health, int damageReduction, int attack) {
        this.name = name;
        this.health = health;
        this.damageReduction = damageReduction;
        this.attack = attack;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
    
    public int getdamageReduction() {
        return this.damageReduction;
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

    public void attack(Fighter enemy) {
    }

    public void sufferDamage(int damage){
        if(this.damageReduction < damage) {
            this.health = damage - this.damageReduction;
        }
    }

}