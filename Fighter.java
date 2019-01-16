import java.util.Random;


public class Fighter {

    protected String name;
    protected int health; 
    protected int maxHealth;
    protected int damageReduction;
    protected int attack;
    protected int defense = 50;
    protected int damage = 10;
    protected Random rnd = new Random();
    
    protected static int maxId = 0;
    private int id;

    public Fighter(String name, int health, int damageReduction, int attack) {
        this.name = name;
        this.maxHealth = health;
        this.health = this.maxHealth;
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
    protected int calculateBaseAttack(Fighter enemy) {
        int baseAttackRoll = rnd.nextInt(100) + this.attack;
        Logger.logBattle(this.name + " -> " + enemy.getName());
        return baseAttackRoll;
    }
    public void attack(Fighter enemy) {
        // To be overriden as needed
    }
    public void sufferAttack(int attackRoll, int damage){
        String logMessage = "";
        if (attackRoll > this.defense) {
            this.health -= damage;
            logMessage += "Hit, " + Integer.toString(damage) + " damage\n";
            logMessage += this.name + " has " + Integer.toString(this.health) + " hit points left.\n";
        } else {
            logMessage += "Miss\n";
        }
        Logger.logBattle(logMessage);

    }
    public void regenerate() {
        this.health = this.maxHealth;
    }
    public int getId() {
        return this.id;
    }
    public void displayData() {
        Logger.sysOutStringData("Id" + Integer.toString(this.id)  + " " + this.name + " " + Integer.toString(this.health));
    }
}