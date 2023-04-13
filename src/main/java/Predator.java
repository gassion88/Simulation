public abstract class Predator extends Creature {
    public int damage;

    public Predator(int hp, int speed, Coordinates coordinates, int damage, int maxHp) {
        super(hp, speed, coordinates, maxHp);
        this.damage = damage;
    }

    public void attack(IInteract interact){
        Herbivore herbivore = (Herbivore)interact;
        herbivore.hp -= damage;
    }

    @Override
    public void toInteract(IInteract interact) {
        attack(interact);
    }
}
