public class Archer extends Character{
    private Bow bow;
    Archer(String name){
        super(name,15,4);
    }
    @Override
    public int attack(Character target) {
        int hit = this.bow.touch();
        int targetLifeAfterAttack = Math.max(0, target.getLife() - hit);
        target.setLife(targetLifeAfterAttack);
        return hit;
    }
    @Override
    public boolean escape() {
        if (Math.random() > 0.25) {
            return true;
        } else {
            return false;
        }
    }
    public void setBow(Bow bowWeapon){
        this.bow = bowWeapon;
    }
}
