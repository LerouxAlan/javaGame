public class Sword extends Weapon{
    Sword(String name, int baseDamage, int randomDamage) {
        super(name, baseDamage, randomDamage, 1);
    }

    public int increaseDamage() {
        int increase = this.baseDamage + (int) Math.floor(Math.random() * this.randomDamage);
        return increase;
    }
}
