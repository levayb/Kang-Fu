/**
 * Kangaroo
 */
public class Kangaroo extends Fighter {

    private int specialAttack;

    public Kangaroo(String name, int health, int damageReduction, int attack){
        
        super(name, health, damageReduction, attack);
    }
    public int bigKick(){
        specialAttack = this.attack + 20;
        if (this.damageReduction - 10 > 0) {
            this.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int tailStike(){
        specialAttack = this.attack + 40;
        if (this.damageReduction - 10 > 0) {
            this.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int incrediblePunch(){
        specialAttack = this.attack + 50;
        if (this.damageReduction - 10 > 0) {
            this.damageReduction -= 10;
        }
        return specialAttack;
    }
}