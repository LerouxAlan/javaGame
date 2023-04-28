public class Character {
    private String name;
    protected int life;
    private int lifeMAX;
    protected int strength;

    Character(String name, int lifeMAX, int strength) {
        this.name = name;
        this.life = lifeMAX;
        this.lifeMAX = lifeMAX;
        this.strength = strength;
    }

    public int attack(Character target) {
        int hitPoint = (int) Math.ceil(Math.random() * this.strength);
        int targetLifeAfterAttack = Math.max(0, target.getLife() - hitPoint);
        int hit = target.getLife() - targetLifeAfterAttack;
        target.setLife(targetLifeAfterAttack);
        return hit;
    }

    public boolean escape() {
        if (Math.random() > 0.5) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getLifeMAX() {
        return lifeMAX;
    }

    public void setLife(int life) {
        this.life = life;
    }

}