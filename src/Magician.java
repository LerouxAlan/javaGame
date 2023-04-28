public class Magician extends Character {

    Magician(String name) {
        super(name, 10, 3);
    }

    public int fireBall(Character target) {
        int damage = (int) Math.ceil(Math.random() * 5) + 5;
        if (Math.random() > 0.25) {
            int targetLifeAfterAttack = Math.max(0, target.getLife() - damage);
            target.setLife(targetLifeAfterAttack);
        } else {
            int playerLifeAfterAttack = Math.max(0, this.getLife() - damage);
            this.life = playerLifeAfterAttack;
            damage = -damage;
        }
        return damage;
    }
}
