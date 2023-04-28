public class Warrior extends Character {
    private Sword sword;

    Warrior(String name) {
        super(name, 20, 5);
    }

    @Override
    public int attack(Character target) {
        int hitPoint = (int) Math.ceil(Math.random() * this.strength) + this.sword.increaseDamage();
        int targetLifeAfterAttack = Math.max(0, target.getLife() - hitPoint);
        int hit = target.getLife() - targetLifeAfterAttack;
        target.setLife(targetLifeAfterAttack);
        return hit;
    }

    public void setSword(Sword excalibur) {
        this.sword = excalibur;
    }
}
