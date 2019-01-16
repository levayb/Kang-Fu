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
    protected String sufferedHitReport;
    private Statistics statistics = new Statistics(this);
    
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
        return baseAttackRoll;
    }
    public String attack(Fighter enemy) {
        String report = this.name + " -> " + enemy.getName() + "\n";
        int attackRoll = calculateBaseAttack(enemy);
        int damage = this.damage;
        boolean hit = enemy.sufferAttack(attackRoll, damage);
        report += enemy.getHitReport();
        if (hit) {
            this.statistics.incrementHits();
        } else {
            this.statistics.incrementMisses();
        }
        return report;
        // To be overriden as needed
    }
    public boolean sufferAttack(int attackRoll, int damage){
        this.sufferedHitReport = "";
        boolean attackHit;
        if (attackRoll > this.defense) {
            attackHit = true;
            this.health -= damage;
            this.sufferedHitReport += "Hit, " + Integer.toString(damage) + " damage\n";
            this.sufferedHitReport += this.name + " has " + Integer.toString(this.health) + " hit points left.\n";
            this.statistics.incrementSufferedHits();
        } else {
            attackHit = false;
            this.sufferedHitReport += "Miss\n";
        }
        return attackHit;

    }

    public void regenerate() {
        this.health = this.maxHealth;
    }

    public int getId() {
        return this.id;
    }

    public String getDataString() {
        return "Id" + Integer.toString(this.id)  + " " + this.name + " " + Integer.toString(this.health);
    }

    public Statistics getStatistics() {
        return this.statistics;
    }

    public String getHitReport() {
        return this.sufferedHitReport;
    }

    public void announceAsWinner() {
        this.statistics.incrementWin();
    }

    public void announceAsLoser() {
        this.statistics.incrementLose();
    }
}