public abstract class Creature extends Entity {
    private final int maxHp;
    public int hp;
    public final int speed;

    public Creature(int hp, int speed, Coordinates coordinates, int maxHp) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
        this.maxHp = maxHp;
    }

    public abstract void makeMove();
    public abstract void  toInteract(IInteract interact);

    public void setHp( int hpAmount) {
        if ((hpAmount + hp) >= maxHp) {
            hp = maxHp;
        } else if ((hp - hpAmount) <= 0 ) {
            hp = 0;
        } else {
            hp += hpAmount;
        }
    }
}
