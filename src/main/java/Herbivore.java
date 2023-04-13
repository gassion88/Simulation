public abstract class Herbivore extends Creature {
    public Herbivore(int hp, int speed, Coordinates coordinates, int maxHp) {
        super(hp, speed, coordinates, maxHp);
    }

    public void eat(IInteract interact) {
        setHp(interact.getHpAmount());
    }

    @Override
    public void toInteract(IInteract interact) {
        eat(interact);
    }
}
