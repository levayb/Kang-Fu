import java.util.Random;


public class Fighter {

    protected String name;
    protected int health; 
    protected int damageReduction;
    protected int attack;
    protected int damage = 10;
    protected static int maxId = 0;
    protected Random roll = new Random();
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
        int attackRoll = roll.nextInt(100);
        enemy.health -= this.damage;
    }

    public void sufferDamage(int damage){
        if(this.damageReduction < damage) {
            this.health = damage - this.damageReduction;
        }
    }

}