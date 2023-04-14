public abstract class Predator extends Creature {
    public int damage;

    public Predator(int hp, int speed, Coordinates coordinates, int damage, int maxHp) {
        super(hp, speed, coordinates, maxHp);
        this.damage = damage;
    }

    public void attack(Entity entity){
        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(damage);
    }

}
