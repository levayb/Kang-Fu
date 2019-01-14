/**
 * Kangaroo
 */
public class Kangaroo extends Fighter {

    private int specialAttack;

    public Kangaroo(String name, int health, int damageReduction, int attack){
        
        super(name, health, damageReduction, attack);
    }
    public int bigKick(){
        specialAttack = super.attack + 20;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int tailStike(){
        specialAttack = super.attack + 40;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int incrediblePunch(){
        specialAttack = super.attack + 50;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }
    public void attack(Fighter enemy) {
        super.attack(enemy);
    }
}