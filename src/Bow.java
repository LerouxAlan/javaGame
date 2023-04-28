public class Bow extends Weapon {

    Bow(String name, int baseDamage, int randomDamage, double accuracy) {
        super(name, baseDamage, randomDamage, accuracy);
    }

    public int touch() {
        if (Math.random() > this.accuracy) {
            return 0;
        } else {
            return this.baseDamage + (int) Math.floor(Math.random() * this.randomDamage);
        }
    }

}
