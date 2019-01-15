import java.util.Random;


public class Fighter {

    protected String name;
    protected int health; 
    protected int damageReduction;
    protected int attack;
    protected int defense = 50;
    protected int damage = 10;
    protected static int maxId = 0;
    protected Random rnd = new Random();
    protected int baseAttackRoll;

    public int id;

    public Fighter(String name, int health, int damageReduction, int attack) {
        this.name = name;
        this.health = health;
        this.damageReduction = damageReduction;
        this.attack = attack;
        this.id = maxId;
        maxId ++;
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
        if (this.health <= 0){
            return true;
        } else {
            return false;
        }
    }

    public void attack(Fighter enemy) {
        this.baseAttackRoll = rnd.nextInt(100) + this.attack;
        Logger.log("ATTACK", this.name + " -> " + enemy.getName());
    }

    public void sufferAttack(int attackRoll, int damage){
        if (attackRoll > this.defense) {
            Logger.log("", "Hit, " + Integer.toString(damage) + " damage");
            Logger.log("",  "has " + Integer.toString(this.health) + " hit points left.");
            this.health -= damage;
        } else {
            Logger.log("", "Miss");
        }

    }

}