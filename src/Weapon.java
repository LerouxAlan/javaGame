public class Weapon {
    private String name;
    protected int baseDamage;
    protected int randomDamage;
    protected double accuracy;

    public Weapon(String name, int baseDamage, int randomDamage, double accuracy) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.randomDamage = randomDamage;
        this.accuracy = accuracy;
    }
}
