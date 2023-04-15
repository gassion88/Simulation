package Entity.Creatures;

import Entity.Entity;
import Map.Coordinates;

public abstract class Predator extends Creature {
    public int damage;

    public Predator(int hp, int speed, Coordinates coordinates, int damage, int maxHp) {
        super(hp, speed, coordinates, maxHp);
        this.damage = damage;
    }

    @Override
    public void toInteract(Entity entity) {
        attack(entity);
    }

    @Override
    public boolean isInteract(Entity entity) {
        if (entity instanceof Herbivore){
            return true;
        } else {
            return false;
        }
    }

    public void attack(Entity entity){
        Herbivore herbivore = (Herbivore)entity;
        herbivore.setHp(-damage);
    }
}
