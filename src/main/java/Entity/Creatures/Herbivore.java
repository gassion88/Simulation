package Entity.Creatures;

import Entity.Creatures.Creature;
import Entity.Entity;
import Map.Coordinates;

public abstract class Herbivore extends Creature {
    public Herbivore(int hp, int speed, Coordinates coordinates, int maxHp) {
        super(hp, speed, coordinates, maxHp);
    }

    @Override
    public void toInteract(Entity entity) {
        eat(entity);
    }

    @Override
    public boolean isInteract(Entity entity) {
        if (entity instanceof IEatable) {
            return true;
        } else {
            return false;
        }
    }

    private void eat(Entity entity) {
        IEatable eatable = (IEatable)entity;
        setHp(eatable.getHpAmount());
    }
}
