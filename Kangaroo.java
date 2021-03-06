/**
 * Kangaroo
 */
public class Kangaroo extends Fighter {


    public Kangaroo(String name, int health, int damageReduction, int attack, int defense){
        super(name, health, damageReduction, attack, defense);
        
    }
    public Kangaroo(int id, String name, int health, int damageReduction, int attack, int defense){
        super(id, name, health, damageReduction, attack, defense);
        
    }
    public int bigKick(){
        int specialAttack = super.attack + 20;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int tailStike(){
        int specialAttack = super.attack + 40;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }

    public int incrediblePunch(){
        int specialAttack = super.attack + 50;
        if (super.damageReduction - 10 > 0) {
            super.damageReduction -= 10;
        }
        return specialAttack;
    }

}